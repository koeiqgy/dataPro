$(function(){

    $("#sub").click(function(){
        var uname=$("#uanme").val();
        var pwd=$("#pwd").val();
        $.ajax({
            type: "post",
            url: "/loginAction",
            data:{uname:uname,pwd:pwd},
            dataType:"json",
            success:function(data){
                console.log(data);
            }
        });
    });
});