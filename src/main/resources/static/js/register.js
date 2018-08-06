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
                localData(data.user);
            }
        });
    });
});

function localData(data){
    localStorage.clear();
    var user = localStorage.getItem("user");
    if(user==null){
        //var user_str=JSON.stringify(data);
        //console.log('data'+ data);
        //console.log('user_str'+ user_str);
        localStorage.setItem("user",data);
    }
}