$(function(){
    console.log(window.location.host);

    $(".ulist").click(function(){
        var $this=$(this);
        $.ajax({
            type : "POST",
            url : "/user/queryuList",
            data : {

            },
            dataType : "json",
            success : function(data) {
                //console.log($(this).html());
                $this.html(data.userName);
            }
        });
    });
    var arrdata= new Array();
    arrdata.push({name:"paul",age:"23"});
    arrdata.push({name:"marry",age:"21"});
    arrdata.push({name:"tom",age:"28"});
    $("#cln").click(function(){
        $.ajax({
            type: "post"   ,
            url: "/user/queryJson",
            data:{
                arrdata:arrdata
            },
            dataType:"json",
            success:function(data){

            }
        });

    });
});