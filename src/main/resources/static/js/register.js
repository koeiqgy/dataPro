$(function(){
    $("#register").click(function(){
        var uname=$("#uname").val();
        var pwd=$("#pwd").val();
        $.ajax({
            type: "post",
            url: "/registerAction",
            data:{SysUserName:uname,SysUserPwd:pwd},
            dataType:"json",
            success:function(data){
                console.log(data);
            }
        });
    });
});