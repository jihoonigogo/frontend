var main = {
    init : function () {
        var _this = this;
        $('#btn-save').on('click', function () { _this.save(); });

    },
    save : function () {
        var data = {
            email: $('#email').val(),
            password: $('#password').val(),
            nickname: $('#nickname').val(),
            level: $('#level').val()
        };
        console.log(email);

            $.ajax({
            type: 'POST',
            url: '/join',
            dataType: 'json',
            contentType:'application/json; charset=utf-8',
            data: JSON.stringify(data)
        }).done(function() {
            alert('회원이 등록되었습니다.');
            window.location.href = '/';
        }).fail(function (error) {
            alert(JSON.stringify(error));
        });
    }
}
main.init();