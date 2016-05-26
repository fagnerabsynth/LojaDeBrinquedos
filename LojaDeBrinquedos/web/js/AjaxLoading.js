var ajaxing = false;


$(document).ready(function () {
    if ($('#loading').length === 0) {
        var modal = "<div class='modal fade' tabindex='-1' id='loading' role='dialog'>\
  <div class='modal-dialog'>\
    <div class='modal-content'>\
      <div class='modal-header'>\
        <h4>\
        <img src=\"imagens/logo.png\" height='40'>\
        <span class='modal-title' id='titulomodal'></span>\
      </div>\
        </h4>\
      <div class='modal-body'>\
        <center id='imgLoading'><img src=\"imagens/loading.gif\" id=\"ldstatus\" ></center>\
      </div>\
      <div class='modal-footer'>\
        <button type='button' class='btn btn-default' data-dismiss='modal'>Fechar Aviso</button>\
      </div>\
    </div>\
</div>";
        $('body').append(modal);
    }


    CriaMenu();
    pagina('Home');
});

$(document).ajaxStart(function () {
    ajaxing = true;
    $('#ldstatus').css({'opacity': '1'});
    $('#loading').modal('show');
    tituloModal(0);
});


$(document).ajaxStop(function () {
    ajaxing = false;
    $('#ldstatus').animate({'opacity': '0'}, 1000, function () {
        $('#loading').modal('hide');
    });
});

function tituloModal(i) {
    if (ajaxing) {
        var ponto = "";
        if (i > 3) {
            i = 0;
        }
        for (var m = 0; m < i; m++)
            ponto += ".";


        $('#titulomodal').html('Carregando' + ponto);
        i++;
        window.setTimeout(function () {
            tituloModal(i);
        }, 350);
    } else {
        $('#titulomodal').html('Carregado!');
    }
}

