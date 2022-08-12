create table atividadePrincipal(
    codigoAtividadePrincipal serial not null primary key,
    descricaoAtividadePrincipal varchar not null
);

create table pessoa(
    codigoPessoa serial not null primary key,
    nomePessoa varchar not null,
    dataNascimentoPessoa date not null,
    cpfPessoa varchar not null unique,
    senhaPessoa varchar not null
);

create table paciente(
    codigoPaciente int not null primary key references pessoa(codigoPessoa),
    numeroCartaoSusPaciente varchar not null,
    statusPaciente boolean not null,
    codigoAtividadePrincipal int not null references atividadePrincipal(codigoAtividadePrincipal)
);

create table medico(
    codigoMedico int not null primary key references pessoa(codigoPessoa),
    crmMedico varchar not null,
    statusMedico boolean not null
);

create table consulta(
    codigoConsulta serial not null primary key,
    dataConsulta date not null,
    horarioConsulta time not null,
    situacaoConsulta varchar not null,
    observacoesConsulta varchar not null,
    codigoPaciente int not null references paciente(codigoPaciente),
    codigoMedico int not null references medico(codigoMedico)
);

create or replace procedure cadastrarAtividadePrincipal(codigo_Atividade_Principal int, descricao_Atividade_Principal varchar) as $$
    begin
        if codigo_Atividade_Principal > 0 then
            update atividadeprincipal set descricaoatividadeprincipal = descricao_Atividade_Principal where codigoatividadeprincipal = codigo_Atividade_Principal;
        else
            insert into atividadeprincipal values(default, descricao_Atividade_Principal);
        end if;
    end;
$$ language plpgsql;

create or replace procedure cadastrarMedico(codigo_Pessoa int, nome_Pessoa varchar, data_Nascimento_Pessoa date, cpf_Pessoa varchar, senha_Pessoa varchar, crm_Medico varchar, status_Medico boolean) as $$
    declare
        idMedico int := 0;
        idPessoa int := 0;
    begin
        select into idMedico codigomedico from medico where codigomedico = codigo_Pessoa;
        select into idPessoa codigopessoa from pessoa where codigopessoa = codigo_Pessoa;
        if idMedico > 0 and idPessoa > 0 then
            update medico set codigomedico = (select cadastrarPessoa(codigo_Pessoa, nome_Pessoa, data_Nascimento_Pessoa, cpf_Pessoa, senha_Pessoa)), crmmedico = crm_Medico, statusmedico = status_Medico where codigomedico = codigo_Pessoa;
        else
            insert into medico values((select cadastrarPessoa(codigo_Pessoa, nome_Pessoa, data_Nascimento_Pessoa, cpf_Pessoa, senha_Pessoa)), crmmedico = crm_Medico, statusmedico = status_Medico);
        end if;
    end;
$$ language plpgsql;






call cadastrarMedico (0, 'a', '2021-02-12', '11111', '222222', '2', true);