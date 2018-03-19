$(function() {
    selectLoad();
})
$().ready(function() {

	$('.summernote').summernote({
		height : '220px',
		lang : 'zh-CN',
		callbacks: {
            onImageUpload: function(files, editor, $editable) {
                sendFile(files);
            }
        }
	});
	validateRule();

});


$.validator.setDefaults({
	submitHandler : function() {
		save(1);
	}
});
function save(status) {
	debugger;
	$("#status").val(status);
	var content_sn = $("#content_sn").summernote('code');
	$("#content").val(content_sn);
	$.ajax({
		cache : true,
		type : "POST",
		url : "/blog/bContent/save",
		data : $('#signupForm').serialize(),// 你的formid
		async : false,
		error : function(request) {
			parent.layer.alert("Connection error");
		},
		success : function(r) {
			if (r.code == 0) {
				parent.layer.msg(r.msg);
				parent.reLoad();
				$("#cid").val(r.cid);

			} else {
				parent.layer.alert(r.msg)
			}
		}
	});
}
function validateRule() {
	var icon = "<i class='fa fa-times-circle'></i> ";
	$("#signupForm").validate({
		rules : {
			title : "required",
			author : "required",
			content : "required"
		},
		messages : {
			title : "请填写文章标题",
			author : "请填写文章作者",
			content : "请填写文章内容"
		}
	});
}

function selectLoad() {

    var html = "";
    $.ajax({
        url : '/system/resourceType/list',
        success : function(data) {
            var list = data.rows;
            //加载数据
            for (var i = 0; i < list.length; i++) {
                html += '<option value="' + list[i].id + '">' + list[i].resourceTypeName + '</option>'
            }
            debugger;
            $(".chosen-select").append(html);
            $(".chosen-select").chosen({
                maxHeight : 200
            });
			//点击事件
            $('.chosen-select').on('change', function(e, params) {
                console.log(params.selected);
                var opt = {
                    query : {
                        type : params.selected,
                    }
                }
                $('#exampleTable').bootstrapTable('refresh', opt);
            });
        }
    });
}

function returnList() {
	var index = parent.layer.getFrameIndex(window.name); // 获取窗口索引
	parent.layer.close(index);
}