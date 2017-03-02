<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>我的账本</title>
    <link rel="stylesheet" href="${system.basePath}/css/bootstrap.min.css">
    <link rel="stylesheet" href="${system.basePath}/css/bootstrap-select.css">
    <link rel="stylesheet" href="${system.basePath}/css/dateSelect.css">
    <link rel="stylesheet" href="${system.basePath}/css/common_admin.css"/>
</head>
<body>


<!--捐款详情-->
<div class="dealDel jkDel">
    <div class="maskAll">
        <div class="dealMask">
            <p class="dealTitle">捐款详情<img src="${system.basePath}/img/common_admin/closeIcon.png" class="rt close" alt=""/></p>
            <p class="maskColor"></p>
            <ul class="maskUl">
                <li><p>时间：<span id="donor_donorTimeStr">2016.01.08  18:21</span></p></li>
                <li><p>状态：<span class="mineStatus" id="donor_status">成功</span></p></li>
                <li><p>施工合同名称：<span id="donor_smartContractName">宁夏母亲水窖项目-张家村水井10座</span></p></li>
            </ul>
            <ul class="maskUl">
                <li><p>捐款金额：<span id="donor_amountStr">1000</span></p></li>
                <li><p>基金管理费：<span id="donor_fundAmountStr">2</span></p></li>
                <li><p>渠道服务费：<span id="donor_channelAmountStr">1</span></p></li>
                <li><p>区块链账户实收：<span id="donor_smartContractAmountStr">997</span></p></li>
            </ul>
            <ul class="maskUl">
                <li><p>捐款人：<span id="donor_donorAddr">15099999999</span></p></li>
                <li><p>受理渠道：<span id="donor_channelName">瑶瑶缴费</span></p></li>
                <li><p>收款人：<span id="donor_fundName">母亲水窖基金</span></p></li>
            </ul>
            <ul class="maskUl">
                <li><p>流水号（哈希）：<span id="donor_donorUUID">0000000000909</span></p></li>
                <li><p>施工合同ID：<span id="donor_smartContractAddr">300001</span></p></li>
            </ul>

            <div class="maskUl">
                <p>备注信息</p>
                <p class="remark" id="donor_remark">捐款的备注信息，捐款的备注信息，捐款的备注信息，捐款的备注信息。捐款的备注信息，捐款的备注信息，捐款的备注信息，捐款的备注信息。捐款的备注信息，捐款的备注信息，捐款的备注信息，捐款的备注信息。捐款的备注信息，捐款的备注信息，捐款的备注信息，捐款的备注信息。。</p>
            </div>
            <p class="backBtn"><button>返回</button></p>
        </div>
    </div>
</div>

<!--提款详情-->
<div class="dealDel tkDel">
    <div class="maskAll">
        <div class="dealMask">
            <p class="dealTitle">合约详情<img src="${system.basePath}/img/common_admin/closeIcon.png" class="rt close" alt=""/></p>
            <p class="maskColor"></p>
            <ul class="maskUl">
                <li><p>时间：<span id="draw_drawTime">2016.01.08  18:21</span></p></li>
                <li><p>状态：<span class="mineStatus" id="draw_status">成功</span></p></li>
                <li><p>施工合同名称：<span id="draw_bargainName">宁夏母亲水窖项目-张家村水井10座</span></p></li>
            </ul>
            <ul class="maskUl">
                <li><p>捐款人：<span id="draw_donorName">母亲水窖基金</span></p></li>
                <li><p>收款人：<span id="draw_contractName">**建筑公司</span></p></li>
                <li><p>提款金额：<span id="draw_amountStr">1000</span></p></li>
            </ul>
            <ul class="maskUl">
                <li><p>流水号（哈希）：<span id="draw_drawUUID">0000000000909</span></p></li>
                <li><p>施工合同ID：<span id="draw_bargainId">300001</span></p></li>
            </ul>
            <div class="maskUl">
                <p>备注信息</p>
                <p class="remark"><span id="draw_remark">项目一期尾款。</span></p>
            </div>
            <p class="backBtn"><button>返回</button></p>
        </div>
    </div>
</div>


<!--header-->
<div class="header">
    <div class="container">
        <div class="lf logoDiv">
            <img src="${system.basePath}/img/common_admin/logo.png" alt=""/>
            <span class="logoTxt">公益捐款 <span class="logoTxtSm">基金会版</span></span>
        </div>
        <div class="rt logoTxtSmRt">
            <p>欢迎您！${userName?if_exists}</p>
        </div>
        <div class="logoTxtSmRt logoAct">
            <p><img src="${system.basePath}/img/common_admin/tkIcon.png" alt=""/>提款</p>
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
            <li><a href="${system.basePath}/admin/myAccountBook" class="curIcon"><img src="${system.basePath}/img/common_admin/mineIcon.png" alt=""/><span>我的账本</span></a></li>
            <li><a href="${system.basePath}/admin/donateContractList"><img src="${system.basePath}/img/common_admin/contributeIcon.png" alt=""/><span>捐献合约</span></a></li>
            <li><a href="${system.basePath}/admin/bargainItemList"><img src="${system.basePath}/img/common_admin/contractIcon.png" alt=""/><span>施工合同</span></a></li>
        </ul>
        <!--rt-->
        <div class="rt secRt">
            <!--账本详情-->
            <div class="accountBook">
                <p class="lf accTxt">账本详情</p>
                <p class="rt"><span>账户余额</span><span class="accMoney">${fund.balanceStr?if_exists}&yen;</span></p>
            </div>
            <!--选择-->
            <div class="choose">
                <form action="">
                    <select id="type" class="selectpicker show-tick form-control">
                        <option>选择类型</option>
                        <option value="1">捐款</option>
                        <option value="2">提款</option>
                    </select>
                    <select name="" id="contract" class="selectpicker show-tick form-control">
                        <option value="">选择合约</option>
                        <option value="">宁夏母亲水窖</option>
                        <option value="">宁夏母亲水窖</option>
                    </select>
                    <div class="timeKuang">
                        <input type="text" id="transDate"  name="transDate" placeholder="选择时间">
                    </div>
                </form>
            </div>
            <!--del-->
            <ul class="mineDel">
                <li class="mineTitle">
                    <span class="mineType">类型</span>
                    <span class="mineTime">时间</span>
                    <span class="mineMoney">金额</span>
                    <span class="mineContract">所属合约</span>
                </li>
                <!--
	                <li class="mineInfo">
	                    <span class="mineType">捐款</span>
	                    <span class="mineTime">2016.01.10 18:00</span>
	                    <span class="mineMoney addMon">+ 2,016.00</span>
	                    <span class="mineContract">宁夏母亲水窖宁夏母亲水窖宁夏母亲水窖宁夏母亲水窖宁夏母亲水窖</span>
	                    <span class="rt delIcon"><img src="${system.basePath}/img/common_admin/delIcon.png" alt=""/></span>
	                </li>
                -->
              	<#list transDetailList as transDetail>
              		 <li class="mineInfo">
	                    <span class="mineType"><#if transDetail.type ='1'> 捐款 <#else> 提款</#if></span>
	                    <span class="mineTime">${transDetail.transTime?if_exists}</span>
	                    <span class="mineMoney addMon"><#if transDetail.type ='1'>+<#else>-</#if>${transDetail.transMoney?if_exists}</span>
	                    <span class="mineContract">${transDetail.contractName?if_exists}</span>
	                    <span class="rt delIcon <#if transDetail.type ='1'>jkIcon<#else>tkIcon</#if>" id="${transDetail.transId?if_exists}"><img src="${system.basePath}/img/common_admin/delIcon.png" alt=""/></span>
	                </li>
              	</#list>
              
              
            </ul>
        </div>
    </div>
</div>

<script src="${system.basePath}/js/jquery-1.11.3.js"></script>
<script src="${system.basePath}/js/admin/dateSelectList.js"></script>
<script src="${system.basePath}/js/bootstrap.js"></script>
<script src="${system.basePath}/js/admin/bootstrap-select.js"></script>
<script src="${system.basePath}/js/admin/common_admin.js"></script>
<script>
    
	$('.logoAct').click(function(){
	    window.location.href="${system.basePath}/admin/login";
	});
     $('.jkIcon').click(function(){
        var transId=$(this).attr("id");
        queryTransDetail(transId,'1');
    });
    $('.tkIcon').click(function(){
        var transId=$(this).attr("id");
        queryTransDetail(transId,'2')
    });


    $('.close').click(function(){
        $('.dealDel').fadeOut();
    });
    $('.backBtn button').click(function(){
        $('.dealDel').fadeOut();
    });


	//type 1 捐款  2 提款
	// 交易id
	function queryTransDetail(transId,type){
		    var postData =  {"transId":transId,"type":type,tm:new Date().getTime()};
			var queryTransDetailUrl='${system.basePath}/admin/queryTransDetail';
			$.ajax({
				type: 'GET',
				url: queryTransDetailUrl,
				data:postData,
				dataType:'json',
				cache: false,
				async: true,//同步方法
				success: function(data){
					console.log(data)
					if('1'==type){//捐款
						$("#donor_donorTimeStr").html(data.donorTimeStr);
						$("#donor_smartContractName").html(data.smartContractName);
						$("#donor_amountStr").html(data.amountStr);
						$("#donor_fundAmountStr").html(data.fundAmountStr);
						$("#donor_channelAmountStr").html(data.channelAmountStr);
						$("#donor_smartContractAmountStr").html(data.smartContractAmountStr);
						$("#donor_donorAddr").html(data.donorAddr);
						$("#donor_fundName").html(data.fundName);
						$("#donor_donorUUID").html(data.donorUUID);
						$("#donor_smartContractAddr").html(data.smartContractAddr);
						$("#donor_remark").html(data.remark);
					
						$('.jkDel').fadeIn();
					}else{//提款
						 $("#draw_drawTime").html(data.drawTime);
						 $("#draw_bargainName").html(data.bargainName);
						 $("#draw_donorName").html(data.donorName);
						 $("#draw_contractName").html(data.smartContractName);
						 $("#draw_amountStr").html(data.amountStr);
						 $("#draw_drawUUID").html(data.drawUUID);
						 $("#draw_bargainId").html(data.bargainId);
						 $("#draw_remark").html(data.remark);
						
						 $('.tkDel').fadeIn();
					}
					
				}
			});
	}
	


	$('#type').change(function(){
        //alert($("#type").val())
        query()
    });
	$('#contract').change(function(){
        //alert($("#type").val())
        query()
    });
	$('#transDate').change(function(){
        //alert($("#type").val())
        query()
    });
		
	function query(){
		var type=$("#type").val();
		var contractId=$("#contract").val();
		var transDate=$("#transDate").val();
		 window.location.href="${system.basePath}/admin/myAccountBook?type="+type+"&contractId="+contractId+"&transDate="+transDate;		
	
	}
	
//    时间
    $("#transDate").dateSelect();
    
    	$(document).ready(function(){
    			var type='${type?if_exists}';
    			//alert("1type="+type)
    			if('1'==type){
    					$("#type option[text='1']").attr("selected", true);
    			}else if('2'==type){
    					$("#type option[text='2']").attr("selected", true);
    			}
    			
    	
		});
    
    
    

</script>
</body>
</html>