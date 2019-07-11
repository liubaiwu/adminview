layui.use(['jquery'], function(){
    var jQuery = layui.$ //重点处
    var $=jQuery;
    jQuery.extend({
        ajaxEx: function (obj) {
            //var layerLoad;
            //var layer;
            //layui.use('layer', function () {
            //    layer = layui.layer;
            //    layerLoad = layer.load(1, {
            //        shade: [0.1, '#000'] //0.1透明度的白色背景
            //    });
            //});
            //var markShadow=jQuery("<div id='markShadow' class='window-mask tree-loading' style='z-index: 9999999;background-color: black; display: none;'></div>");
            //jQuery(document.body).append(markShadow);
            //markShadow.fadeIn(800);
            var opts ={
                    type : obj.type,
                    url : obj.url,
                    data : obj.data,
                    dataType : obj.dataType,
                    success: function (data) {

                        obj.success(data);
                    },
                    error : ajaxError,
                complete: function (d) {
                    //layer.close(layerLoad);
                        //$("#markShadow").remove();
                    }
                };
            if(obj.contentType)
                opts.contentType = obj.contentType;
            if(obj.async)
                opts.async = obj.async;
            $.ajax(opts);
        }
    });
});
ajaxError = function (XMLHttpRequest, textStatus, errorThrown) {
    debugger;
    var status = XMLHttpRequest.status;
    if (errorThrown.message != undefined && errorThrown.message.length >= 0) {   //登陆超时
        try {
            layui.use('layer', function () {
                var layer = layui.layer;
                layer.alert('登录超时,重新登录', function () {
                    if (window != top) {
                        top.location.href = location.href;
                    }
                    else {
                        window.location.href = location.href;
                    }
                });
            });
        }
        catch (err) {
            alert('登录超时,请刷新页面,重新登录');
        }
	}else if(status == '1001'){       //没有权限
        try {
            layui.use('layer', function () {
                var layer = layui.layer;
                layer.alert('没有权限');
            });
        }
        catch (err) {
            alert('没有权限');
        }
	}else if(status == '0'){                            //服务停止
        try {
            layui.use('layer', function () {
                var layer = layui.layer;
                layer.alert('服务器拒绝了连接');
            });
        }
        catch (err) {
            alert('服务器拒绝了连接');
        }
	}else{
        try {
            layui.use('layer', function () {
                var layer = layui.layer;
                layer.alert(errorThrown);
            });
        }
        catch (err) {
            alert(errorThrown);
        }
	}
}

document.onkeydown = function(e) {
	event = event||e;
	var obj = event.srcElement||event.target;
	_search(obj,event.keyCode == 13);
}
var _search = function(sr,isEnter) {
	if(isEnter)
		while(sr.parentNode) {
			sr=sr.parentNode;
			if(sr.tagName=="HTML")
				return false;
			if(sr.getAttribute("search")) {
				eval(sr.getAttribute("search")+"()");
				return true;
			}
		}
	return false;
}
//$.fn.combobox.methods = jQuery.extend($.fn.combobox.methods,{focus:function(jq){
//	return jq.each(function(){
//	$(this).combobox('showPanel');
//	$(this).combobox('textbox').focus();
//	});
//}})