let index = {
	let _this = this;
	init:function(){
		//JQuery
		$("#btn-save").on("click", function(){  //this를 바인딩 하기 위해서 사용
			_this.save();
		}); 
	},
	
	save:function(){
		//alert("user의 save 함수 호출됨 ");
		let data = {
			//이 값들을 찾아서 data object에 넣어줌 
			username: $("#username").val(),
			password: $("#password").val(),
			email: $("#email").val()
		}
		//값 잘 들고 왔는지 확인
		//console.log(data);
		
		//ajax호출 시 default가 비동기 호출 
		//ajax 통신을 이용해서 3개의 데이터를 json으로 변경하여 insert요청
		$.ajax({
			//회원가입 수행 요청 
			type:"POST",
			url:"/blog/api/user",
			data: JSON.stringify(data), //data를 json형태로 바꿔주기 
			contentType:"application/json; charset=utf-8", //body데이터가 어떤 타입인지(MIME)
			dataType: "json" //요청을 서버로해서 응답이 왔을 때 기본적으로 모든 것이 문자열 (생긴게 json이라면) => javascript오브젝트로 변
		}).done(function(resp){ //응답의 결과가 
			//성공시 
			alert("회원가입이 완료되었습니다.");
			location.href = "/blog";
		}).fail(function(error){
			//실패시 
			alert(JSON.stringify(error));
		}); 
		
	}
}
index.init();