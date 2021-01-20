$(function() {
	// solving active menu problem
	switch (menu) {

	case 'About Us':
		$('#about').addClass('active');
		break;

	case 'Contact Us':
		$('#contact').addClass('active');
		break;

	case 'All Products':
		$('#listproducts').addClass('active');
		break;

	default:
		if (menu == "Home")
			break;
		$('#listproducts').addClass('active');
		$('#a_' + menu).addClass('active');
		break;

	}

	// code for jquery datatables
	// create a dataset

	var products = [ 	
						[ '1', 'ABC1' ],
						[ '2', 'ABC2' ], 
						[ '3', 'ABC3' ],
						[ '4', 'ABC4' ], 
						[ '5', 'ABC5' ], 
						[ '6', 'ABC6' ], 
						[ '7', 'ABC7' ],
						[ '8', 'ABC8' ]
					];
	
	var $table = $('#productListTable');
	
	//execute the below code only where we have this table
	
	if($table.length){
		
		//console.log('inside the table!');
		
		$table.DataTable({
			
			lengthMenu: [[3,5,10,-1],['3 Records','5 Records','10 Records','All Records']],
			pageLength:5,
			data: products
		});
	}
	
	
	

});