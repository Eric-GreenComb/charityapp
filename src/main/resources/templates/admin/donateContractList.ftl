<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>捐献合约</title>
    <link rel="stylesheet" href="${system.basePath}/css/dateSelect.css">
    <link rel="stylesheet" href="${system.basePath}/css/common_admin.css"/>
</head>
<body>

<!--添加合约-->
<div class="dealDel" id="addCon">
    <div class="maskAll">
        <div class="dealMask">
            <p class="dealTitle conTitle">添加合约<img src="${system.basePath}/img/common_admin/closeIcon.png" class="rt close" alt=""/></p>
            <p class="maskColor conColor"></p>
            <div class="conAll">
                <form action="">
                    <div class="lf conLf">
                        <div><p>甲方</p><p>捐款者</p></div>
                        <div><p>乙方</p><p>中国妇女基金会母亲水窖基金委员会</p></div>
                        <div>
                            <p>合约名称</p>
                            <p><textarea name=""  cols="30" rows="10" placeholder="作为捐款项目名称"></textarea></p>
                        </div>
                        <div>
                            <p>合约详情</p>
                            <p><textarea name="" cols="30" rows="10" placeholder="对捐款项目的描述"></textarea></p>
                        </div>
                        <div>
                            <p>选择合约类型</p>
                            <p><input type="radio" name="type" value="money" id="conMoney"/><label for="conMoney">金额限制</label> <input type="text" placeholder="请输入最高限度金额"/></p>
                            <p><input type="radio" name="type" value="time" id="conTime"/><label for="conTime">时间限制</label> <input type="text" placeholder="请输入合约最后期限"/></p>
                        </div>
                    </div>
                    <div class="rt conRt conLf">
                        <div>
                            <p>渠道服务费</p>
                            <p><input type="text" placeholder="请输入渠道服务费的费率"/></p>
                        </div>
                        <div>
                            <p>基金管理费</p>
                            <p><input type="text" placeholder="请输入基金管理费的费率"/></p>
                        </div>
                        <div>
                            <p>生效时间</p>
                            <div class="timeKuang timeCon"><input type="text" id="contractTime" placeholder="请输入基金管理费的费率"/></div>
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
            <p class="backBtn"><button>返回</button></p>
        </div>
    </div>
</div>
<!--合同详情-->
<div class="dealDel" id="contractDetail">
    <div class="maskAll">
        <div class="dealMask">
            <p class="dealTitle">合同详情<img src="${system.basePath}/img/common_admin/closeIcon.png" class="rt close" alt=""/></p>
            <p class="maskColor"></p>
            <ul class="maskUl">
                <li><p>合同名称：<span>宁夏母亲水窖项目</span></p></li>
                <li><p>甲方：<span>中国妇女基金会母亲水窖基金委员会</span></p></li>
                <li><p>乙方：<span>农村城建公司</span></p></li>
            </ul>
            <ul class="maskUl">
                <li><p>工程状态：<span class="mineStatus">已验收</span></p></li>
                <li><p>合同有效期：<span>2016.1.1-2017.1.1</span></p></li>
            </ul>
            <ul class="maskUl">
                <li><p>合同ID：<span>300001</span></p></li>
                <li><p>合同详情：<span>为张家村修建10座水井，分三期付款</span></p></li>
            </ul>
            <ul class="maskUl">
                <li><p>收款账号开户行：<span>招商银行</span></p></li>
                <li><p>收款账户：<span>626000000000000</span></p></li>
            </ul>
            <ul class="maskUl">
                <li><p>备注信息：<span>捐款的备注信息</span></p></li>
            </ul>
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
            <p class="backBtn"><button>返回</button></p>
        </div>
    </div>
</div>
<!--提款记录-->
<div class="dealDel" id="drawMoney">
    <div class="maskAll">
        <div class="dealMask">
            <p class="dealTitle conTitle">提款<img src="${system.basePath}/img/common_admin/closeIcon.png" class="rt close" alt=""/></p>
            <p class="maskColor conColor"></p>
            <div class="conAll drawAll">
                <form action="">
                    <div class="lf conLf drawDiv">
                        <div><p>捐款合约ID</p><p>3000001</p></div>
                        <div><p>捐款合约名称</p><p>宁夏母亲水窖项目</p></div>
                        <div><p>实收捐款（区块链余额）</p><p>9999700.00 &yen;</p></div>
                        <div>
                            <p>提款金额</p>
                            <p><input type="text" placeholder="输入要提取的款项金额"/></p>
                        </div>
                        <div>
                            <p>施工合同</p>
                            <p class="doCon">选择款项用于的合同<span></span></p>
                        </div>
                        <div>
                            <p>备注</p>
                            <p><textarea name="" cols="30" rows="10" placeholder="对捐款项目的描述"></textarea></p>
                        </div>
                    </div>
                    <div class="rt conLf drawDivRt">
                        <div><p>合同名称</p><p>宁夏母亲水窖项目</p></div>
                        <div><p>施工状态</p><p class="mineStatus">施工中</p></div>
                        <div><p>甲方</p><p>中国妇女基金会母亲水窖基金委员会</p></div>
                        <div><p>乙方</p><p>农村城建公司</p></div>
                        <div><p>合同ID</p><p>3000001</p></div>
                        <div><p>收款账户开户行</p><p>招商银行</p></div>
                        <div><p>收款账户</p><p>62600000000000000</p></div>
                    </div>
                </form>
            </div>
            <p class="backBtn"><button>确认提款</button></p>
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
            <p>欢迎您！中国妇女基金会母亲水窖基金委员会</p>
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
            <li><a href="${system.basePath}/admin/myAccountBook" ><img src="${system.basePath}/img/common_admin/mineIcon.png" alt=""/><span>我的账本</span></a></li>
            <li><a href="${system.basePath}/admin/donateContractList" class="curIcon"><img src="${system.basePath}/img/common_admin/contributeIcon.png" alt=""/><span>捐献合约</span></a></li>
            <li><a href="${system.basePath}/admin/bargainItemList"><img src="${system.basePath}/img/common_admin/contractIcon.png" alt=""/><span>施工合同</span></a></li>
            
        </ul>
        <!--rt-->
        <div class="rt secRt">
            <!--账本详情-->
            <div class="accountBook">
                <p class="lf accTxt">捐献合约</p>
                <p class="rt addContract"><img src="${system.basePath}/img/common_admin/addContractICon.png" alt=""/><span>添加合约</span></p>
            </div>
            <!--del-->
            <ul class="mineDel conDel">
                <li class="mineTitle">
                    <span class="conID">合约ID</span>
                    <span class="conName mineContract">合约名称</span>
                    <span class="conMoney">余额</span>
                    <span class="conTime">创建日期</span>
                    <span class="conStatus">状态</span>
                </li>
                <!-- 
		                <li class="mineInfo">
		                    <span class="conID">AU000001</span>
		                    <span class="conName mineContract">宁夏母亲水窖</span>
		                    <span class="conMoney">0.00</span>
		                    <span class="conTime">2016.01.10</span>
		                    <span class="conStatus">未开始</span>
		                    <span class="rt delIcon contractDel"><img src="${system.basePath}/img/common_admin/delIcon.png" alt=""/></span>
		                    <span class="rt delIcon drawMoney"><img src="${system.basePath}/img/common_admin/con_tkIcon.png" alt=""/></span>
		                    <span class="rt delIcon">
		                        <a href="contribute_list.html"><img src="${system.basePath}/img/common_admin/con_hyDelIcon.png" alt=""/></a>
		                    </span>
		                </li>
		                <li class="mineInfo">
		                    <span class="conID">AU000001AU000001</span>
		                    <span class="conName mineContract">宁夏母亲水窖宁夏母亲水窖宁夏母亲水窖</span>
		                    <span class="conMoney">9999999999.00</span>
		                    <span class="conTime">2016.01.10</span>
		                    <span class="conStatus">未开始</span>
		                    <span class="rt delIcon contractDel"><img src="${system.basePath}/img/common_admin/delIcon.png" alt=""/></span>
		                    <span class="rt delIcon drawMoney"><img src="${system.basePath}/img/common_admin/con_tkIcon.png" alt=""/></span>
		                    <span class="rt delIcon">
		                        <a href="contribute_list.html"><img src="${system.basePath}/img/common_admin/con_hyDelIcon.png" alt=""/></a>
		                    </span>
		                </li>
                -->
                <#list smartContractExts as smartContractExt>
                	 <li class="mineInfo">
	                   <span class="conID">${smartContractExt.addr?if_exists}</span>
	                    <span class="conName mineContract">${smartContractExt.smartContract.name?if_exists}</span>
	                    <span class="conMoney">${smartContractExt.balanceYuan?if_exists}</span>
	                    <span class="conTime">${smartContractExt.smartContract.createTimeStr?if_exists}</span>
	                    <span class="conStatus">${smartContractExt.smartContract.status?if_exists}</span>
	                    <span class="rt delIcon contractDel"><img src="${system.basePath}/img/common_admin/delIcon.png" alt=""/></span>
	                    <span class="rt delIcon drawMoney"><img src="${system.basePath}/img/common_admin/con_tkIcon.png" alt=""/></span>
	                    <span class="rt delIcon">
	                        <a href="contribute_list.html"><img src="${system.basePath}/img/common_admin/con_hyDelIcon.png" alt=""/></a>
	                    </span>
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
    $('.backBtn button').click(function(){
        $('.dealDel').fadeOut();
    });
    $('.close').click(function(){
        $('.dealDel').fadeOut();
    });
    //    添加合同
    $('.addContract').click(function(){
        //$('#addCon').fadeIn();
        alert("暂不开放此功能")
    });
    $('#file').change(function(){
        $(this).next().html($(this).val() );
    });
//添加合约时间
$("#contractTime").dateSelect();




//    合同详情
$('.contractDel').click(function(){
    $('#contractDetail').fadeIn();
});

//    提款记录
$('.drawMoney').click(function(){
    $('#drawMoney').fadeIn();
});
$('.doCon').click(function(){
    $('#drawMoney .drawDiv').css("transform",'translateX(0)');
    $('#drawMoney .drawDiv').css("transition",'transform 0.3s');
    $('.drawDivRt').fadeIn();
});

</script>
</body>
</html>