$(document).ready(function () {


});

function addOrder(id) {
    var questionId = $('#questionId' + id).val();
   /* $.ajax({
        url: baseUrl + 'lox/questions/' + questionId,
        type: "PUT",
        data: {question: $('#questionString' + id).val()},
        success: function (data) {
            window.location.href = baseUrl + "lox/questions/";
        },
        error: function (jqXHR, textStatus, errorThrown) {
            hideErrorMessages();
            if (jqXHR.status === 400)
                showValidationMessages(jqXHR.responseJSON);
            else if (jqXHR.status === 401) {
                window.location.href = baseUrl + "lox/login";
            }
        }
    });*/
}