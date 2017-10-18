//分页查询开始
$(document).ready(function() {
    getDataList(0, null);
});

//异步提交表单
var options={
	url:"/authority/add_register", //form提交数据的地址
	type:"post", //form提交的方式(method:post/get)
//	target:"#listData2", //服务器返回的响应数据显示在元素(Id)号确定
//	beforeSubmit:function(){
//		alert('准备提交 ');
//	}, //提交前执行的回调函数
	success:function(data) {
//		insertData(data);
		alert("添加成功");
	}, //提交成功后执行的回调函数
	dataType:"json", //服务器返回数据类型
	clearForm:true, //提交成功后是否清空表单中的字段值
	restForm:true, //提交成功后是否重置表单中的字段值，即恢复到页面加载时的状态
	timeout:6000 //设置请求时间，超过该时间后，自动退出请求，单位(毫秒)。
}
function submitForm(){
	$('#regist_form').ajaxSubmit(options);
}


var rows = 10;
var page = 1;
var initFlag = true;

function getDataList(currPage, jg) {
    $.ajax({
        url : "/authority/regist_list/",
        type : "get",
        dataType : 'json',
        data : {
        	recordId: $("#recordId").val() ,
        	rows : rows,
        	page : currPage + 1
        },
        contentType : "application/x-www-form-urlencoded; charset=utf-8",
        success : function(response) {
            if (response.result) {
                if (response.data != null && response.data != ""&& response.total != undefined && response.total > 0) {
                    if (initFlag) {
                        $("#Pagination").pagination(
                                response.total,
                                {
                                    items_per_page : rows,
                                    num_edge_entries : 1,
                                    num_display_entries : 8,
                                    callback : getDataList//回调函数
                                });
                        initFlag = false;
                    }
                    $("#listData").html("");
                    loadDataList(response.data);
                } else {
                    //暂无数据
                }
            } else {
                //暂无数据
            }
        }
    });
}
function loadDataList(listdata) {
    //表头
    var html ="<tr class='t-header'>"+
                    "<td>NO.</td>"+
                    "<td>注册码</td>"+
                    "<td>节点数</td>"+
                    "<td>硬盘号</td>"+
                    "<td>CPU序列号</td>"+
                    "<td>起始日期</td>"+
                    "<td>截止日期</td>"+
               "</tr>";
    $("#listData").append(html);
    for (var i = 0; i < listdata.length; i++) {
    	var n = listdata[i];
        var html = "<tr>"+
	        "<td>"+(i + 1)+"</td>"+
	        "<td>"+n.code+"</td>"+
	        "<td>"+n.node+"</td>"+
	        "<td>"+n.ser_hdd+"</td>"+
	        "<td>"+n.ser_cpu+"</td>"+
	        "<td>"+n.date_start+"</td>"+
	        "<td>"+n.date_end+"</td>"+
        "</tr>";
        $("#listData").append(html);
    }
}
//分页查询结束