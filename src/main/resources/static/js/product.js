/*$(document).ready(function () {


 });*/
var root = "[(@{/})]";
var port = window.location.port;
var baseUrl = window.location.protocol + '//' + window.location.hostname + (port !== 80 ? ':' + port : '' );

function addOrder(id) {
    var orderType = $('#orderType' + id).val();
    var quantity = $('#itemQuantity' + id).val();
    var totalPriceText = $('#totalPrice' + id);

    console.log('orderType= ' + orderType);
    console.log('Quantity=' + quantity);
    console.log('Product Id = ' + id);
    console.log(baseUrl);
    $.ajax({
        url: baseUrl + '/rest/products/' + id,
        type: "POST",
        data: {quantity: quantity, orderType: orderType},
        success: function (data) {
            totalPriceText.text(data);
            //window.location.href = baseUrl + "lox/questions/";
        },
        error: function (jqXHR, textStatus, errorThrown) {
            if (jqXHR.status === 400)
                showValidationMessages(jqXHR.responseJSON);
            else if (jqXHR.status === 401) {
                window.location.href = baseUrl + "lox/login";
            }
        }
    });
}