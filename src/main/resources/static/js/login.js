$(function(){
    $("#sub").click(function(){
        var uname=$("#uanme").val();
        var pwd=$("#pwd").val();
        var token = localStorage.getItem("user");
        console.log(token);
        $.ajax({
            type: "post",
            url: "/loginAction",
            data:{uname:uname,pwd:pwd},
            dataType:"json",
            beforeSend: function(request) {
                request.setRequestHeader("Authorization", token);
            },
            success:function(data){
                console.log(data);
            }
        });
    });
});