$(document).ready(function() {



        $.get('/phone-matrix/distribution-model', {}, function(data) {

                phone(data)

        });



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
