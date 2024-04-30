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

        $('#IDupdateSHOP').val(id);
        $('#login').val($(this).parents('tr:first').find('td:eq(1)').text(),data);
          $('#role').val($(this).parents('tr:first').find('td:eq(2)').text(),data);
          $('#shopIskra').val($(this).parents('tr:first').find('td:eq(3)').text(),data);
          $('#shopUNF').val($(this).parents('tr:first').find('td:eq(4)').text(),data),
          $('#clusterIskra').val($(this).parents('tr:first').find('td:eq(5)').text(),data);
          $('#clusterT2').val($(this).parents('tr:first').find('td:eq(6)').text(),data);
          $('#clusterRtk').val($(this).parents('tr:first').find('td:eq(7)').text(),data);
          $('#simT2').val($(this).parents('tr:first').find('td:eq(8)').text(),data);
          $('#simMts').val($(this).parents('tr:first').find('td:eq(9)').text(),data);
          $('#simMf').val($(this).parents('tr:first').find('td:eq(10)').text(),data);

    });
}

function del() {
    $(document).find('.DEL').on('click', function() {
        var id = $(this).parents('tr:first').find('td:eq(0)').text(),
            data;

        $.get('/ui/shop/delete/' + id, {}, function(data) {
            $(".Store").html(data);
        });
    });
}
