layui.use(['form', 'layedit', 'laydate'], function(){ //独立版的layer无需执行这一句
	var $ = layui.jquery, 
	layer = layui.layer,
	form = layui.form,
	laydate = layui.laydate
	; //独立版的layer无需执行这一句
//	
	form.render();
	//监听提交  
	form.on('submit(regist_form_filter)', function(data){
//		layui验证通过
	  $('#regist_form').ajaxSubmit(options);
//	    阻止跳转
	  return false;
	});

	//执行一个laydate实例
	laydate.render({
	  theme: "molv",
	  elem: 'input[name="date_start"]' //指定元素
	});

	$('#_menu').on('click', 'button', function(){
//		打开添加注册码层
		layer.open({
		  type: 2, // Page层类型
		  area: ['500px', '550px'],
		  resize : false,
//			offset: ['100px', '50px'],
		  title: '添加用户信息',
		  btn: ['添加'],//按钮1的回调是yes，而从按钮2开始，则回调为btn2: function(){}，以此类推
		  shadeClose: true, //是否点击遮罩关闭
		  scrollbar: false,
		  shade: 0.6, // 遮罩透明度
		  maxmin: false, // 允许全屏最小化
		  anim: 1, // 0-6的动画形式，-1不开启
		  skin: "layui-layer-molv",
		  content: '/user/form',
		  closeBtn: 1,
		  yes: function(index, layero){
//		    var iframeWin = window[layero.find('iframe')[0]['name']]; //得到iframe页的窗口对象，执行iframe页的方法：iframeWin.method();
//		    console.log(body.html()) //得到iframe页的body内容
		    var body = layer.getChildFrame('body', index);
		    body.find('#btn_submit').click();
		  }
		});
	});
});


//异步提交表单
var options={
	url:"/user/add", //form提交数据的地址
	type:"post", //form提交的方式(method:post/get)
//	target:"#listData2", //服务器返回的响应数据显示在元素(Id)号确定
	beforeSubmit:function(){
	}, //提交前执行的回调函数
	success:function(data) {
//		insertData(data);
		layer.alert("添加成功");
	}, //提交成功后执行的回调函数
	error:function(){
		layer.alert("提交失败");
	},
	dataType:"json", //服务器返回数据类型
	clearForm:true, //提交成功后是否清空表单中的字段值
	restForm:true, //提交成功后是否重置表单中的字段值，即恢复到页面加载时的状态
	timeout:6000 //设置请求时间，超过该时间后，自动退出请求，单位(毫秒)。
}

//分页查询开始
var rows = 10;
var page = 1;
var initFlag = true;
function getDataList(currPage, jg) {
    $.ajax({
        url : "/user/page_list",
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