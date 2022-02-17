//method의 post,get 방식이 아닌 json 방식 사용하기 위해 js파일 생성 

let index = {
	init: function(){
		$("#btn-save").on("click", ()=>{
			this.save(); //this : 자기 자신의 값, 오버로딩 된 다른 생성자 호출 
		});
	}, //버튼 누르면!
	
	save : function(){
		let data = {
			username : $("#username").val(),
			password : $("#password").val(),
			email: $("#email").val()
		}
		//세가지 정보 보내줌!
		
		//ajax호출시 default가 비동기 호출 
		//ajax 통신을 이용해서 3개의 데이터를 json으로 변경하여 insert 요청!
		//ajax가 통신을 성공하고 json을 리턴해주면 자동으로 자바 오브젝트로 변환해줌 
		$.ajax({
			//회원가입 수행 요청 
			type : "POST",
			url: "/blog/api/user",
			data: JSON.stringify(data),
			contentType:"application/json; charset=utf-8" //body 데이터가 어떤 타입인지 
			//dataType: "json" //응답이 왔을 때 문자열 (생긴게 json이라면) => javascript 
		}).done(function(resp){
			alert("회원가입이 완료되었습니다.");
//			console.log(resp);
			location.href="/blog";
		}).fail(function(error){
			alert(JSON.stringify(error));
		});
	}
	
}

index.init();