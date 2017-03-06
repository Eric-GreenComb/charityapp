<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>搜索</title>
    <link rel="stylesheet" href="${system.basePath}/css/common_pc.css"/>
</head>
<body>

<!--header-->
<div class="header">
    <div class="container">
        <div class="lf logoDiv">
            <img src="${system.basePath}/img/common_pc/logo.png" alt=""/>
            <span class="logoTxt">区块链浏览器</span>
        </div>
        <div class="rt header_top_down">
            <p class="search_con">
                <input type="text" id="searchVal" class="search" value="" placeholder="高度、UUID、交易ID" />
                <label for="search"><a href="javascript:searchDetail();"><img src="${system.basePath}/img/common_pc/search.png" alt=""/></a></label>
            </p>
        </div>
    </div>
</div>


<!--section-->
<div class="section">
    <div class="container">
        <dl class="searchNull">
           <dt><img src="${system.basePath}/img/common_pc/searchNull.png" alt=""/></dt>
           <dd>没有找到您搜索的内容，请返回 <a href="${system.basePath}/explorer/index">首页</a> 继续浏览～</dd>
        </dl>
    </div>
</div>

<script src="${system.basePath}/js/jquery-1.11.3.js"></script>
<script src="${system.basePath}/js/common_pc.js"></script>
<script>
function searchDetail(){
		var searchVal=$("#searchVal").val();
		console.log("searchVal="+searchVal)
		if(""!=searchVal){
			window.location.href="${system.basePath}/explorer/searchDetail?searchVal="+searchVal;
		}else{
			alert("请输入查询条件,区块高度或是txid!")
		}
		
	}
</script>
</body>
</html>