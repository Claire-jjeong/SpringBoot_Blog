let index = {
	init:function(){
		//JQuery
		$("#btn-save").on("click", ()=>{
			this.save();
		}); //btn-save가 클릭이 되면 
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
		
		$ajax().done().fail(); //ajax 통신을 이용해서 3개의 데이터를 json으로 변경하여 insert요청
		
	}
}
index.init();