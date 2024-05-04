$(document).ready(function() {

    update()
    del()
    var target = document.querySelector('.Store');
    MutationObserver = window.MutationObserver || window.WebKitMutationObserver;
    var observer = new MutationObserver(function(mutations, observer) {
        update()
        del()
    });
    var config = {
        attributes: true,
        childList: true,
        characterData: true
    }
    observer.observe(target, config);
});

function update() {
    $(document).find('.UPDATE').on('click', function() {

 var id = $(this).parents('tr:first').find('td:eq(0)').text(),data;

        $('#IDm').val(id);
        $('#RainbowNomenclature').val($(this).parents('tr:first').find('td:eq(1)').text(),data);
          $('#ManufacturersArticle').val($(this).parents('tr:first').find('td:eq(2)').text(),data);
          $('#Name').val($(this).parents('tr:first').find('td:eq(3)').text(),data);

    });
}

function del() {
    $(document).find('.DEL').on('click', function() {
        var id = $(this).parents('tr:first').find('td:eq(0)').text(),
            data;

        $.get('/ui/marwel/delete/' + id, {}, function(data) {
            $(".Store").html(data);
        });
    });
}
