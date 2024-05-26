var group, shop, a, nomenclature;
$(document).ready(function() {
    var target = document.querySelector('.shop');
    MutationObserver = window.MutationObserver || window.WebKitMutationObserver;
    var observer = new MutationObserver(function(mutations, observer) {
        updateCash()
        scrollInto()
    });
    var config = {
        attributes: true,
        childList: true,
        characterData: true
    }
    observer.observe(target, config);
    $('#table_cash .btn').on('click', function() {
        group = $(this).parents('tr:first').find('td:eq(0)').text().trim();
        $.get('/ui/distribution/Sale?group=' + encodeURIComponent(group), {}, function(data) {
            $(".cash").html(data);
            // $("#grad").html(grop);
        });
    });
    $('#table_shop .btn').on('click', function() {
        shop = $(this).parents('tr:first').find('td:eq(0)').text().trim();
        updateShop()
    });
    $('#table_shop2 .btn').on('click', function() {
        shop = $(this).parents('tr:first').find('td:eq(0)').text().trim();
        updateShop()
    });
});

function updateCash() {
    $('.shop .btn').on('click', function() {
        group = $(this).parents('tr:first').find('td:eq(0)').text().trim();
        $.get('/ui/distribution/Sale?group=' + encodeURIComponent(group), {}, function(data) {
            $(".cash").html(data);
            // $("#grad").html(grop);
        });
    });
}

function updateShop() {
    $.get('/ui/distribution/shop?shop=' + encodeURIComponent(shop), {}, function(data) {
        $(".shop").html(data);
        // $("#grad").html(grop);
        $(document).find('.minMatrix').on('click', function() {
            if (a != undefined) {
                a.parents().nextAll('.hide_minMatrix').toggle();
            }
            a = $(this);
            a.parents().nextAll('.hide_minMatrix').toggle();
        });
        $(document).find('.form-control').on('change', function() {
            nomenclature = $(this).parents('tr:first').find('td:eq(0)').text()
            var order = $(this).parents('tr:first').find('td:eq(4)').text()
            let AllSalesShop = {
                shop: shop,
                distributionModel: nomenclature,
                name: group,
                order: this.value,
            };
            $('#loader').removeClass('hidden')
            sendRequest('POST', '/distribution/update', AllSalesShop).then(data => distribution(data)).catch(err => console.log(err))
        });
    });
}

function scrollInto() {
    var tds = document.querySelectorAll('.minMatrix');
    for (var i = 0; i < tds.length; i++) {
        if (tds[i].innerHTML == group) {
            tds[i].scrollIntoView(true);
            tds[i].click();
        }
    }
}


function distribution(data) {
    console.log(data)
    var tds = document.querySelectorAll('#table_cash td');
    for (var i = 0; i < tds.length; i++) {
        for (var j = 0; j < data.remainsCash.length; j++) {
            if (tds[i].lastElementChild != null && tds[i].lastElementChild.innerHTML == data.remainsCash[j].model) {
                tds[i + 1].innerHTML = data.remainsCash[j].remainsCash1 == 0 ? null : data.remainsCash[j].remainsCash1;
                tds[i + 2].innerHTML = data.remainsCash[j].remainsCash2 == 0 ? null : data.remainsCash[j].remainsCash2;
            }
        }
    }
    var tds = document.querySelectorAll('#table_shop td');
    for (var i = 0; i < tds.length; i++) {
        for (var j = 0; j < data.indicatorsShopList.length; j++) {
            if (tds[i].lastElementChild != null && tds[i].lastElementChild.innerHTML == data.indicatorsShopList[j].shop) {
                tds[i + 1].innerHTML = data.indicatorsShopList[j].remains == 0 ? null : data.indicatorsShopList[j].remains;
            }
        }
    }
    var tds = document.querySelectorAll('#table_shop2 td');
    for (var i = 0; i < tds.length; i++) {
        for (var j = 0; j < data.indicatorsShopMult.length; j++) {
            if (tds[i].lastElementChild != null && tds[i].lastElementChild.innerHTML == data.indicatorsShopMult[j].shop) {
                tds[i + 1].innerHTML = data.indicatorsShopMult[j].remains == 0 ? null : data.indicatorsShopMult[j].remains;
            }
        }
    }
}

function sendRequest(method, url, body = null) {
    return new Promise((resolve, reject) => {
        const xhr = new XMLHttpRequest()
        xhr.open(method, url)
        xhr.responseType = 'json'
        xhr.setRequestHeader('Content-Type', 'application/json')
        xhr.onload = () => {
            if (xhr.status >= 400) {
                reject(xhr.response)
            } else {
                resolve(xhr.response)
            }
        }
        xhr.onerror = () => {
            reject(xhr.response)
        }
        xhr.send(JSON.stringify(body))
    })
}