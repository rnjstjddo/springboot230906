console.log("index.js 파일 main 진입");
var main ={
     init : function(){

        console.log("index.js 파일 main-> init 진입");
        var _this = this;

        $("#registerBtn").on('click', function(){

            console.log("index.js 파일 main-> init 등록버튼 클릭");
            _this.save();
        });

       $("#modifyBtn").on('click', function(){
                console.log("index.js 파일 main-> init 수정버튼 클릭");
                _this.update();
            });
    },//main- init

    save : function(){
        console.log("index.js 파일 main-> save 진입");

        var data={
            title : $("#title").val(),
            content: $("#content").val(),
            author: $("#author").val()
        };

        $.ajax({
            type:'post',
            url:'/api/v1/posts',
            dataType:'json',
            contentType:'application/json; charset=utf-8',
            data:JSON.stringify(data),

            success: function(result){
                console.log("index.js ajax 성공 success함수 진입 ");
                alert(result+ "게시글이 등록되었습니다.");
                window.location.href='/';

            },
            error: function(){
                console.log("index.js ajax 성공 error함수 진입 ");
                console.log(error);
                alert(JSON.stringify(error));
            }
        });//ajax
    },//main - save

    update: function(){

        console.log("index.js 파일 main-> update 진입");

        var data={
            title: $("#title").val(),
            content:$("#content").val()
        }

        var id =$("#id").val();

        $.ajax({
            type:'put',
            url:'/api/v1/posts/'+id,
            dataType:'json',
            contentType:'application/json; charset=utf-8',
            data: JSON.stringify(data)

        })//$.ajax
        .done(function(){
        console.log("index.js 파일 main-> done() 진입");

            alert("게시글이 수정되었습니다.");
            window.location.href='/';
        })
        .fail(function(error){
        console.log("index.js 파일 main-> fail() 진입");

            alert(JSON.stringify(error));
        });//fail
    }//main- update

};//var main

main.init();