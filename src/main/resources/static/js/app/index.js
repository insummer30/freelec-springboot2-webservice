// index 스코프 안에 필요한 함수들을 모아둔다.
var index = {
    // 초기화 함수로 버튼 리스너를 달아준다.
    init: function() {
        var _this = this;
        $('#btn-save').on('click', function() {
            _this.save();
        });
    },

    // 게시글을 저장하는 역할을 해준다.
    save: function() {
        var data = {
            title: $('#title').val(),
            author: $('#author').val(),
            content: $('#content').val()
        };

        $.ajax({
            type: 'POST',
            url: '/api/v1/posts',
            dataType: 'json',
            contentType: 'application/json; charset=UTF-8',
            data: JSON.stringify(data)
        }).done(function() {
            alert('글이 등록 되었습니다.');
            window.location.href = '/';
        }).fail(function(error) {
            alert(JSON.stringify(error));
        });
    }
};

// 해당 스코프 초기화 함수를 호출해준다.
index.init();