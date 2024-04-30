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

        $('#ID').val(id);
        $('#name').val($(this).parents('tr:first').find('td:eq(1)').text(),data);
          $('#email').val($(this).parents('tr:first').find('td:eq(2)').text(),data);
          $('#number').val($(this).parents('tr:first').find('td:eq(3)').text(),data);
          $('#manager').val($(this).parents('tr:first').find('td:eq(4)').text(),data);
             });
}

function del() {
    $(document).find('.DEL').on('click', function() {
        var id = $(this).parents('tr:first').find('td:eq(0)').text(),
            data;

        $.get('/ui/suppliers/delete/' + id, {}, function(data) {
            $(".Store").html(data);
        });
    });
}
