//分页查询开始
$(document).ready(function() {
//	获取所有销售记录
    getDataList(0, null);
//  获取所有产品下拉框数据
    getProductList();
//  获取所有用户下拉框数据
    getSalerList();
//  获取所有用户下拉框数据
    getUserList();
});

layui.use(['form', 'layedit', 'laydate'], function(){ //独立版的layer无需执行这一句
	var $ = layui.jquery, 
	layer = layui.layer,
	form = layui.form,
	laydate = layui.laydate
	; //独立版的layer无需执行这一句

	form.render();
	//监听提交  
	form.on('submit(record_form_filter)', function(data){
		submitForm();
		return false;
	});
	//执行一个laydate实例
	laydate.render({
	  elem: 'input[name="date_supply"]' //指定元素
	});
	$('#btn_prod_form').on('click', function(){
		layer.open({
			  type: 2 // Page层类型
			  ,area: ['500px', '300px']
			  ,title: '你好，layer。'
			  ,shade: 0.6 // 遮罩透明度
			  ,maxmin: true // 允许全屏最小化
			  ,anim: 1 // 0-6的动画形式，-1不开启
			  ,content: '/prod_add_form.html'
			});
  	});
	$('#btn_saler_form').on('click', function(){
// 			alert(1);
		layer.open({
			  type: 2 // Page层类型
			  ,area: ['500px', '300px']
			  ,title: '你好，layer。'
			  ,shade: 0.6 // 遮罩透明度
			  ,maxmin: true // 允许全屏最小化
			  ,anim: 1 // 0-6的动画形式，-1不开启
			  ,content: '/saler_add_form.html'
			});
  	});
	$('#btn_saler_form').on('click', function(){
// 			alert(1);
		layer.open({
			  type: 2 // Page层类型
			  ,area: ['500px', '300px']
			  ,title: '你好，layer。'
			  ,shade: 0.6 // 遮罩透明度
			  ,maxmin: true // 允许全屏最小化
			  ,anim: 1 // 0-6的动画形式，-1不开启
			  ,content: '/user_add_form.html'
			});
  	});
});


//异步提交表单
var options={
	url:"/record/add", //form提交数据的地址
	type:"post", //form提交的方式(method:post/get)
//	target:"#listData2", //服务器返回的响应数据显示在元素(Id)号确定
//	beforeSubmit:function(){
//		alert('准备提交 ');
//	}, //提交前执行的回调函数
	success:function(data) {
//		insertData(data);
		layer.msg('添加成功'); 
	}, //提交成功后执行的回调函数
	error: function(e) { 
		layer.msg('提交失败'); 
	},
	dataType:"json", //服务器返回数据类型
	clearForm:true, //提交成功后是否清空表单中的字段值
	restForm:true, //提交成功后是否重置表单中的字段值，即恢复到页面加载时的状态
	timeout:6000 //设置请求时间，超过该时间后，自动退出请求，单位(毫秒)。
}
function submitForm(){
	$('#record_form').ajaxSubmit(options);
}

var rows = 10;
var page = 1;
var initFlag = true;

function getDataList(currPage, jg) {
    $.ajax({
        url : "/record/data_list",
        type : "get",
        dataType : 'json',
        data : {rows : rows,page : currPage + 1},
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
    for (var i = 0; i < listdata.length; i++) {
    	var n = listdata[i];
        html = html + "<tr>"+
	        "<td>"+(i + 1)+"</td>"+
	        "<td>"+n.username+"</td>"+
	        "<td>"+n.productName+"</td>"+
	        "<td>"+n.price+"</td>"+
	        "<td>"+new Date(n.createDate).format("yyyy-MM-dd")+"</td>"+
	        "<td>"+new Date(n.supplyDate).format("yyyy-MM-dd")+"</td>"+
	        "<td>"+n.salerName+"</td>"+
	        "<td><a href='/regist/list/"+n.id+"' title='"+n.id+"' >查看注册码</a></td>"+
        "</tr>";
    }
    $("#listData").append(html);
}
//分页查询结束

//开始请求销售人员列表
function getSalerList(){
	$.ajax({
        url : "/saler/list",
        type : "get",
        dataType : 'json',
        contentType : "application/x-www-form-urlencoded; charset=utf-8",
        success : function(listdata) {
        	$("#saler").html(""); //清空元素内容
        	var html = "<select name='sid'>";
            for (var i = 0; i < listdata.length; i++) {
            	var n = listdata[i];
            	html = html+ "<option value='"+n.id+"'>"+n.name+"</option>";
            }
            html = html + "</select>";
            $("#saler").append(html);
        }
    });
}
//开始请求用户人员列表
function getUserList(){
	$.ajax({
		url : "/user/list",
		type : "get",
		dataType : 'json',
		contentType : "application/x-www-form-urlencoded; charset=utf-8",
		success : function(listdata) {
			$("#user").html(""); //清空元素内容
			var html = "<select name='cid'>";
			for (var i = 0; i < listdata.length; i++) {
				var n = listdata[i];
				html = html + "<option value='"+n.id+"'>"+n.name+"</option>";
			}
			html = html + "</select>";
			$("#user").append(html);
		}
	});
}
//开始请求产品列表
function getProductList(){
	$.ajax({
		url : "/prod/list",
		type : "get",
		dataType : 'json',
		contentType : "application/x-www-form-urlencoded; charset=utf-8",
		success : function(listdata) {
			$("#prod").html(""); //清空元素内容
			var html = "<select name='pid'>";
			for (var i = 0; i < listdata.length; i++) {
				var n = listdata[i];
				html = html + "<option value='"+n.id+"'>"+n.name+"</option>";
			}
			html = html + "</select>";
			$("#prod").append(html);
		}
	});
}