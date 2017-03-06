<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>施工合同</title>
    <link rel="stylesheet" href="${system.basePath}/css/dateSelect.css">
    <link rel="stylesheet" href="${system.basePath}/css/common_admin.css"/>
</head>
<body>

<!--添加合同-->
<div class="dealDel" id="addCon">
<!--有内容-->
<!-- 
    <div class="maskAll">
        <div class="dealMask">
            <p class="dealTitle conTitle">添加合同<img src="${system.basePath}/img/common_admin/closeIcon.png" class="rt close" alt=""/></p>
            <p class="maskColor conColor"></p>
            <div class="conAll">
                <form action="">
                    <div class="lf conLf contractLf">
                        <div><p>甲方</p><p>捐款者</p></div>
                        <div>
                            <p>乙方</p>
                            <p><input type="text" placeholder="施工方的单位名称"/></p>
                        </div>
                        <div>
                            <p>合同名称</p>
                            <p><input type="text" placeholder="施工项目合同名称"/></p>
                        </div>
                        <div>
                            <p>合同有效期</p>
                            <p class="timeKuang timeDur"><input type="text" id="timeDuring01" placeholder="起始时间"/></p>
                            <span>至</span>
                            <p class="timeKuang timeDur"><input type="text" id="timeDuring02" placeholder="截止日期"/></p>
                        </div>
                        <div>
                            <p>合同详情</p>
                            <p><textarea name="" cols="30" rows="10" placeholder="对捐款项目的描述"></textarea></p>
                        </div>
                    </div>
                    <div class="lf conRt conLf">
                        <div>
                            <p>收款账户开户行</p>
                            <p><input type="text" placeholder="请认真核对"/></p>
                        </div>
                        <div>
                            <p>首款账号</p>
                            <p><input type="text" placeholder="请认真核对"/></p>
                        </div>
                        <div>
                            <p>备注</p>
                            <p><textarea name="" cols="30" rows="10" placeholder="对捐款项目的描述"></textarea></p>
                        </div>
                        <div>
                            <p>合约附件</p>
                            <p class="fileP">
                                <input type="file" placeholder="可上传多个文件" id="file" class="file"/>
                                <span></span>
                                <label for="file">添加文件</label>
                            </p>
                        </div>
                    </div>
                </form>
            </div>
            <p class="backBtn"><button class="closeBtn cancel">取消</button><button class="done">完成</button></p>
        </div>
    </div>
    -->
    <div class="maskAll noPermissionAll">
        <div class="noPermission">
            <p>抱歉，此功能权限暂未开放！</p>
            <p class="noPermissionBtn"><button class="cancel">确认</button></p>
        </div>
    </div>
</div>
<!--合同详情-->
<div class="dealDel" id="contractDetail">
    <div class="maskAll" style="top:15%;">
        <div class="dealMask" style="height:450px;">
            <p class="dealTitle">施工合同详情<img src="${system.basePath}/img/common_admin/closeIcon.png" class="rt close" alt=""/></p>
            <p class="maskColor"></p>
            <ul class="maskUl">
                <li><p>合同名称：<span id="contractDetail_name"></span></p></li>
                <li><p>甲方：<span id="contractDetail_A"></span></p></li>
                <li><p>乙方：<span id="contractDetail_B"></span></p></li>
            </ul>
            <ul class="maskUl">
                <li><p>工程状态：<span class="mineStatus" id="contractDetail_status"></span></p></li>
                <li><p>合同有效期：<span id="contractDetail_startTime"></span><span id="contractDetail_endTime"></span></p></li>
            </ul>
            <ul class="maskUl">
                <li><p>合同ID：<span id="contractDetail_id"></span></p></li>
                <li><p>合同详情：<span id="contractDetail_detail"></span></p></li>
            </ul>
            <ul class="maskUl">
                <li><p>收款账号开户行：<span id="contractDetail_bank"></span></p></li>
                <li><p>收款账户：<span id="contractDetail_account"></span></p></li>
            </ul>
            <ul class="maskUl">
                <li><p>备注信息：<span id="contractDetail_remark">无</span></p></li>
            </ul>
            <!-- 
		            <ul class="maskUl">
		                <li>
		                    <p class="lf">合同附件：</p>
		                    <p class="lf"><span class="contractColor">张家村水窖项目合同.pdf</span><br><span class="contractColor"> 张家村水窖项目验收报告.pdf</span></p>
		                </li>
		            </ul>
		            <div class="maskUl">
		                <p>收款明细</p>
		                <p class="remark conMark"><span>收款次数：</span><span>3</span></p>
		                <p><span>收款金额：</span><span>500000元</span></p>
		            </div>
            -->
            <p class="backBtn"><button class="closeBtn">返回</button></p>
        </div>
    </div>
</div>
<!--验收-->
<div class="dealDel" id="checkAll">
<!-- 
    <div class="maskAll">
        <div class="dealMask">
            <p class="dealTitle conTitle">验收<img src="${system.basePath}/img/common_admin/closeIcon.png" class="rt close" alt=""/></p>
            <p class="maskColor conColor"></p>
            <div class="conAll">
                <form action="">
                    <div class="lf conLf contractLf">
                        <div><p>合同名称</p><p>宁夏母亲水窖项目</p></div>
                        <div><p>施工状态</p><p class="mineStatus">施工中</p></div>
                        <div><p>乙方</p><p>农村城建公司</p></div>
                        <div><p>合同ID</p><p>3000001</p></div>
                        <div><p>合同有效期</p><p>2016.10.01～2017.01.01</p></div>
                        <div><p>合同详情</p><p>为张家村修建10座水井，分三期付款，一期xxxx，二期xxxx，三期xxxx</p></div>
                    </div>
                    <div class="rt conRt conLf">
                        <div>
                            <p>合同附件</p>
                            <p class="kanCon"><span class="lf">张家村水窖项目合同.pdf</span><span class="rt">查看文件</span></p>
                        </div>
                        <div>
                            <p>验收报告</p>
                            <p class="fileP">
                                <input type="file" placeholder="可上传多个文件" id="conFile" class="file"/>
                                <span></span>
                                <label for="conFile">添加文件</label>
                            </p>
                        </div>
                        <div>
                            <p>施工现场图</p>
                            <ul class="checkUl">
                                <li>
				    <img src="${system.basePath}/img/common_admin/img01.png" alt=""/>
				    <span class="deleteCheckImg"><img src="${system.basePath}/img/common_admin/checkDeleteIcon.png" alt=""/></span>
				</li>
                                <li class="checkAdd">
                                    <a>
                                        <input type="file" accept="image/gif, image/jpeg,image/png,image/jpg" onchange="picChange(this)"/>
                                        <img src="${system.basePath}/img/common_admin/checkAdd.png" alt=""/>
                                    </a>
                                </li>
                            </ul>
                        </div>
                    </div>
                </form>
            </div>
            <p class="backBtn"><button class="closeBtn cancel">取消</button><button class="done">确认验收</button></p>
        </div>
    </div>
    -->
    <div class="maskAll noPermissionAll">
        <div class="noPermission">
            <p>抱歉，此功能权限暂未开放！</p>
            <p class="noPermissionBtn"><button class="cancel">确认</button></p>
        </div>
    </div>
</div>

<!--header-->
<div class="header">
    <div class="container">
        <a href="${system.basePath}/admin/index">
        <div class="lf logoDiv">
            <img src="${system.basePath}/img/common_admin/logo.png" alt=""/>
            <span class="logoTxt">公益捐款 <span class="logoTxtSm">基金会版</span></span>
        </div></a>
        <div class="rt logoTxtSmRt">
            <p>欢迎您！中国妇女发展基金会</p>
        </div>
        <div class="logoTxtSmRt logoAct">
            <!-- 
           		<p><img src="${system.basePath}/img/common_admin/tkIcon.png" alt=""/>提款</p>
           -->
            <p><img src="${system.basePath}/img/common_admin/tcIcon.png" alt=""/>退出</p>
        </div>
    </div>
</div>
<!--section-->
<div class="section">
    <div class="container">
        <!--lf-->
          <ul class="lf secLf">
            <li><a href="${system.basePath}/admin/index" ><img src="${system.basePath}/img/common_admin/accountIcon.png" alt=""/><span>账户概览</span></a></li>
            <li><a href="${system.basePath}/admin/myAccountBook" ><img src="${system.basePath}/img/common_admin/mineIcon.png" alt=""/><span>我的账本</span></a></li>
            <li><a href="${system.basePath}/admin/donateContractList" ><img src="${system.basePath}/img/common_admin/contributeIcon.png" alt=""/><span>捐献合约</span></a></li>
            <li><a href="${system.basePath}/admin/bargainItemList" class="curIcon"><img src="${system.basePath}/img/common_admin/contractIcon.png" alt=""/><span>施工合同</span></a></li>
        </ul>
        
        <!--rt-->
        <div class="rt secRt">
            <!--账本详情-->
            <div class="accountBook">
                <p class="lf accTxt">施工合同</p>
                <p class="rt addContract"><img src="${system.basePath}/img/common_admin/addContractICon.png" alt=""/><span>添加合同</span></p>
            </div>
            <!--del-->
            <ul class="mineDel contractUl ">
                <li class="mineTitle">
                    <!-- <span class="contractID">合约ID</span>-->
                    <span class="contractName" style="width:200px">合约名称</span>
                    <span class="conWhere">施工方</span>
                    <span class="contractTime">合同有效期</span>
                    <span class="conStatus">状态</span>
                </li>
               
                
                  <#list bargainList as bargain>
                  	 <li class="mineInfo">
	                   <!-- <span class="contractID">${bargain.addr?if_exists}</span>-->
	                    <span class="contractName" style="width:200px">${bargain.name?if_exists}</span>
	                    <span class="conWhere">${bargain.partyB?if_exists}</span>
	                    <span class="contractTime">${bargain.bargainDate?if_exists}</span>
	                    <span class="conStatus">${bargain.bargainStatus?if_exists}</span>
	                    <span class="rt delIcon contractDel" id="${bargain.addr?if_exists}"><img src="${system.basePath}/img/common_admin/delIcon.png" alt=""/></span>
	                    <span class="rt delIcon checkIcon"><img src="${system.basePath}/img/common_admin/checkIcon.png" alt=""/></span>
	                </li>
                </#list>
                
            </ul>
        </div>
    </div>
</div>

<script src="${system.basePath}/js/jquery-1.11.3.js"></script>
<script src="${system.basePath}/js/admin/dateSelect.js"></script>
<script src="${system.basePath}/js/admin/common_admin.js"></script>
<script>
    //    colse
    $('.logoAct').click(function(){
    window.location.href="${system.basePath}/admin/login";
});
    $('.backBtn button.closeBtn').click(function(){
        $('.dealDel').fadeOut();
    });
    $('button.closeBtn').click(function(){
        $('.dealDel').fadeOut();
    });
    $('.close').click(function(){
        $('.dealDel').fadeOut();
    });
     $('button.cancel').click(function(){
        $('.dealDel').fadeOut();
    });
    //    添加合同
    $('.addContract').click(function(){
        $('#addCon').fadeIn();
    });
    $('#file').change(function(){
        $(this).next().html($(this).val() );
    });
    $('#conFile').change(function(){
        $(this).next().html($(this).val() );
    });

    //    合同详情
    $('.contractDel').click(function(){
     var bargainAddr=$(this).attr("id");
     queryBargainExt(bargainAddr);
    });

//    验收
    $('.checkIcon').click(function(){
        $('#checkAll').fadeIn();
    });


    //    时间
    try{
 		$("#timeDuring01").dateSelect();
    	$("#timeDuring02").dateSelect();
    }catch(e){
    }

	function queryBargainExt(bargainAddr){
		    var postData =  {"bargainAddr":bargainAddr,tm:new Date().getTime()};
			var queryBargainExtUrl='${system.basePath}/admin/queryBargainExt';
			$.ajax({
				type: 'GET',
				url: queryBargainExtUrl,
				data:postData,
				dataType:'json',
				cache: false,
				async: true,//同步方法
				success: function(data){
					console.log(data)
					$("#contractDetail_name").html(data.name);
					$("#contractDetail_A").html(data.partyA);
					$("#contractDetail_B").html(data.partyB);
					$("#contractDetail_status").html(data.bargainStatus);
					var startTime = data.startTime;
					$("#contractDetail_startTime").html(startTime.replace("-",".").replace("-","."));
					if(data.endTime != null && data.endTime != ""){
						var endTime = data.endTime;
						$("#contractDetail_endTime").html("-"+endTime.replace("-",".").replace("-","."));
					}
					var addd =data.addr;
					var adds = addd.split(":");
					$("#contractDetail_id").html(adds[0]);
					$("#contractDetail_detail").html(data.detail);
					$("#contractDetail_bank").html(data.depositBank);
					$("#contractDetail_account").html(data.bankAccount);
					if(data.remark != null && data.remark != ""){
						$("#contractDetail_remark").html(data.remark);
					}
					 $('#contractDetail').fadeIn();
				}
			});
	}
    function picChange(obj){

            var f=obj.files[0];
            var img = new Image();
            img.file = f;
            img.onload=function() {
                var str="<li><img src='"+img.src+"'/><span class='deleteCheckImg'><img src='${system.basePath}/img/common_admin/checkDeleteIcon.png' alt=''/></span></li>";
                $('.checkAdd').before(str);
            }
            var reader = new FileReader();
            reader.onload = function(e){
                img.src = e.target.result;
            };
            reader.readAsDataURL(f);

    }


     $('.checkUl').on("click",".deleteCheckImg",function(){
            $(this).parent().remove();
    });

</script>
</body>
</html>