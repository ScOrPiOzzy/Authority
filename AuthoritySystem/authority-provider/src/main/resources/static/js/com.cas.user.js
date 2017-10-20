//分页查询开始
$(document).ready(function() {
    getDataList(0, null);
});
var rows = 10;
var page = 1;
var initFlag = true;

function getDataList(currPage, jg) {
    $.ajax({
        url : "/user/data_list",
        type : "get",
        dataType : 'json',
        data : {
        	rows : rows,
        	page : currPage + 1
        },
        contentType : "application/x-www-form-urlencoded; charset=utf-8",
        success : function(response) {
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
        }
    });
}
function loadDataList(listdata) {
    var html;
    if(listdata.length == 0){
    	html="<tr><td></td><td></td><td></td><td></td><td></td></tr>"
    }else{
		for (var i = 0; i < listdata.length; i++) {
			var n = listdata[i];
			html = html + "<tr>"+
			"<td>"+(i + 1)+"</td>"+
			"<td>"+n.name+"</td>"+
			"<td>"+n.mobile+"</td>"+
			"<td>"+n.qq+"</td>"+
			"<td>"+n.weixin+"</td>"
			"</tr>";
		}
    }
    
    $("#listData").append(html);
}
//分页查询结束
////异步提交表单
//var options={
//	url:"/regist/add", //form提交数据的地址
//	type:"post", //form提交的方式(method:post/get)
////	target:"#listData2", //服务器返回的响应数据显示在元素(Id)号确定
////	beforeSubmit:function(){
////		alert('准备提交 ');
////	}, //提交前执行的回调函数
//	success:function(data) {
////		insertData(data);
//		layer.alert("添加成功");
//	}, //提交成功后执行的回调函数
//	error:function(){
//		layer.alert("提交失败");
//	},
//	dataType:"json", //服务器返回数据类型
//	clearForm:true, //提交成功后是否清空表单中的字段值
//	restForm:true, //提交成功后是否重置表单中的字段值，即恢复到页面加载时的状态
//	timeout:6000 //设置请求时间，超过该时间后，自动退出请求，单位(毫秒)。
//}
//function submitForm(){
//	$('#regist_form').ajaxSubmit(options);
//}


