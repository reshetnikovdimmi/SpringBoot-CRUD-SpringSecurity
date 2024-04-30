$(document).ready(function() {
let today = new Date().toISOString().slice(0, 10);
    $('#showDate').val(today)
        update()

        del()

        $.get('/phone-matrix/distribution-model', {}, function(data) {

                phone(data)

        });

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

function phone(data) {

    var s = '<option selected disabled value="' + "select option" + '">' + "select option" + '</option>';
    for (const [key, value] of Object.entries(data)) {
        s += '<option value="' + key + '">' + key + '</option>';
    }
    $('#brend').html(s);
    $('#brend ').on('change', function() {
        var s = '<option selected disabled value="' + "select option" + '">' + "select option" + '</option>';
        for (const [key, value] of Object.entries(data)) {
            if (key == $(this).val()) {
                for (const [key1, value1] of Object.entries(value)) {
                    s += '<option value="' + key1 + '">' + key1 + '</option>';
                }
                $('#y_name').html(s);
                $('#y_name').on('change', function() {
                    var s = '<option selected disabled value="' + "select option" + '">' + "select option" + '</option>';
                    for (const [key1, value1] of Object.entries(value)) {
                        if (key1 == $(this).val()) {
                            value1.forEach((item, index) => {
                                s += '<option value="' + `${item}` + '">' + `${item}` + '</option>';
                            });
                            $('#models').html(s);

                        }
                    }
                });
            }
        }
    });
}
function update() {
    $(document).find('.UPDATE').on('click', function() {

 var id = $(this).parents('tr:first').find('td:eq(0)').text(),data;

        $('#id').val(id);

          $('#brend').val($(this).parents('tr:first').find('td:eq(1)').text(),data).change();
          $('#y_name').val($(this).parents('tr:first').find('td:eq(2)').text(),data).change();
          $('#models').val($(this).parents('tr:first').find('td:eq(3)').text(),data).change();
          $('#price').val($(this).parents('tr:first').find('td:eq(4)').text(),data);
          $('#price_promo').val($(this).parents('tr:first').find('td:eq(5)').text(),data);
          $('#startPromo').val($(this).parents('tr:first').find('td:eq(6)').text(),data);
          $('#endPromo').val($(this).parents('tr:first').find('td:eq(7)').text(),data),
          $('#compensation').val($(this).parents('tr:first').find('td:eq(8)').text(),data);
        });
}

function del() {

    $(document).find('.DEL').on('click', function() {
        var id = $(this).parents('tr:first').find('td:eq(0)').text(),
            data;

        $.get('/ui/promo/delete/' + id, {}, function(data) {
            $(".Store").html(data);
        });
    });
}