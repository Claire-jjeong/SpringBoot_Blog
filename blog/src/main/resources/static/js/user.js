let index = {
	init: function(){
		$("#btn-save").on("click", ()=>{
			this.save();
		});
	},
	
	save : function(){
		let data = {
			username : $("#username").val(),
			password : $("#password").val(),
			email: $("#email").val()
		}
		
		//ajax호출시 default가 비동기 호출 
		//ajax 통신을 이요해서 3개의 데이터를 json으로 변경하여 insert 요청!
		$.ajax({
			//회원가입 수행 요청 
			type : "POST",
			url: "/blog/api/user",
			data: JSON.stringify(data),
			contentType:"application/json; charset=utf-8", //body 데이터가 어떤 타입인지 
			dataType: "json" //응답이 왔을 때 문자열 (생긴게 json이라면) => javascript 
		}).done(function(resp){
			alert("회원가입이 완료되었습니다.");
			alert(resp);
			location.href="/blog";
		}).fail(function(error){
			alert(JSON.stringify(error));
		});
	}
	
}

index.init();