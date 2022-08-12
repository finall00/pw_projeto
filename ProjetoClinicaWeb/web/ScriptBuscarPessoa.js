$("input#cpfPessoa").blur(function () {
    let cpfPessoa = $(this).val();
    $.getJSON("BuscarPessoa", {cpfPessoa: cpfPessoa}, function (resp) {
        if (resp.erro === undefined) {
            $("input#codigoPessoa").val(resp.codigoPessoa);
            $("input#nomePessoa").val(resp.nomePessoa);
            $("input#dataNascimentoPessoa").val(resp.dataNascimentoPessoa);
        } else {
            alert(resp.erro);
        }
    });
});