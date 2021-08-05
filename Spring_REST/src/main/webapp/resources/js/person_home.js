/**
 * 
 */

const display = document.querySelector('#display');
const selectBtn = document.querySelector('#selectBtn');


	selectBtn.addEventListener('click', () => {
	const xhttp = new XMLHttpRequest();
		
	
	
	xhttp.addEventListener('readystatechange', (e) => {
		const target = e.target;
		const httpStatus = e.target.status;
		const readyState = target.readyState;
		
		
		
		
		
			myobj = JSON.parse(target.responseText);
			console.log(myobj);
			
			Object.keys(myobj).forEach((key)=> {
				const new_node = document.createElement('tr');
				new_node.innerHTML = '<td>' + myobj[key] + '</td>';
				display.appendChild(new_node);
			})
		
		
		
	});
	xhttp.open('GET', '/rest/work/getSelect', true);
	xhttp.send();

});