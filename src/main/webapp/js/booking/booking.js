
$templateReservation = null;
var flag = true;

// function setReservationForm(idRoom) {
//     getTemplateReservation(idRoom);
// }
//
// function getTemplateReservation(id) {
//     $.get("/templates/pages/booking/templateReservation.html", "html")
//         .done(function(html){
//             $templateReservation = html;
//             $('body').append($templateReservation);
//             var roomName = $('#room_name').text();
//             // $('#idContentReservation').html($templateReservation);
//             var tre = $('#template_room_name');
//             $(document.getElementById('mainFormReservationInfo').firstElementChild).children().last().children().last().val(id);
//         })
//         .fail(function(){ $templateRoom.html("failed to get:" + src); });
//}

function getReservationData(editBody) {
    var firstDate;
    var secondDate;
    var result = '';
    flag = true;
    $(editBody).each(function(){
        $("div",this).each(function() {
            if(this.className=='col-sm-9') {
                var key = $(this.firstElementChild).attr('name');
                var value = $(this.firstElementChild).val();
                if(key == 'id' && value == ''){
                    value ="0";
                }else{
                    if($(this.firstElementChild).get(0).tagName == 'SELECT'){
                        value = value.substr(0,value.indexOf(' '))
                    }
                }
                if(value==''){
                    alert("Заполните дату!");
                    flag = false;
                    return false;
                }
                result = result.concat('&',key,'=', value);
            }
        });
    });
    if(currentUser!=null)
        result = result.concat('&','idUser','=', currentUser['id']);
    else
        result = result.concat('&','idUser','=', '0');

    result = result.concat('&','costAdditionalServices','=', '0');
    result = result.concat('&','idDiscount','=', '1');

    return result;
}

function sendReservation() {
    var editBodyUpdate = $('#mainFormReservationInfo');
    var data = getReservationData(editBodyUpdate[0]);
    if(flag)
    $.ajax({
        type: 'POST',
        url: '/add?tableName=RESERVATION' + data +'&rights='+generatePermissionsUser(),
        success: function () {
            alert("Комната успешно забронирована!");
            var services = document.getElementById("idServicesA");
            services.click();
        },
        error: function (result) {
            alert(result.responseText);
        }
    });
}

function acceptReservationRoom() {
    sendReservation();
    // if(flag) {
    //
    // }
}