/*
    index.js만의 scope를 형성하기 위해서 이와 같이 index 변수를 만들고 그 안에 함수를 정의해서 사용한다.
*/
var index = {
    // 초기화 함수로 버튼 리스너를 달아준다.
    init: function() {
        var _this = this;
        $('#btn-save').on('click', function() {
            _this.save();
        });

        $('#btn-update').on('click', function() {
            _this.update();
        });

        $('#btn-delete').on('click', function() {
            _this.delete();
        })
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
    },

    update: function() {
        var data = {
            title: $('#title').val(),
            content: $('#content').val()
        };

        let id = $('#id').val();

        $.ajax({
            type: 'PUT',
            url: '/api/v1/posts/' + id,
            dataType: 'json',
            contentType: 'application/json; charset=UTF-8',
            data: JSON.stringify(data)
        }).done(function() {
            alert('글이 수정되었습니다.');
            window.location.href = '/';
        }).fail(function(error) {
            alert(JSON.stringify(error));
        });
    },

    delete: function() {
        let id = $('#id').val();

        $.ajax({
            type: 'DELETE',
            url: '/api/v1/posts/' + id,
            dataType: 'json',
            contentType: 'application/json; charset=UTF-8'
        }).done(function() {
            alert('글이 삭제되었습니다.');
            window.location.href = '/';
        }).fail(function(error) {
            alert(JSON.stringify(error));
        });
    }
};

// 해당 스코프 초기화 함수를 호출해준다.
index.init();