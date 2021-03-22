<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<div class="container">

	<div class="row">

		<c:if test="${not empty message}">
			<div class="col-xs-12">

				<div class="alert alert-success alert-dismissible">

					<button type="button" class="close" data-dismiss="alert">&times;</button>
					${message}

				</div>

			</div>
		</c:if>

		<div class="col-md-offset-2 col-md-8">

			<div class="panel panel-primary">

				<div class="panel-heading">

					<h4>Product Management</h4>

				</div>
				<div class="panel-body">

					<!-- Form Elements -->
					<sf:form class="form-horizontal" modelAttribute="product"
						action="${contextRoot}/manage/products" method="POST"
						enctype="multipart/form-data">

						<div class="form-group">

							<label class="control-label col-md-4" for="name">Enter
								Product Name: </label>

							<div class="col-md-8">

								<sf:input type="text" path="name" id="name"
									placeholder="Product Name" class="form-control" />
								<sf:errors path="name" style="color: #ff0000;" element="em" />

							</div>

						</div>

						<div class="form-group">

							<label class="control-label col-md-4" for="brand">Enter
								Brand Name: </label>

							<div class="col-md-8">

								<sf:input type="text" path="brand" id="brand"
									placeholder="Brand Name" class="form-control" />
								<sf:errors path="brand" style="color: #ff0000;" element="em" />
							</div>

						</div>

						<div class="form-group">

							<label class="control-label col-md-4" for="description">Product
								Description: </label>

							<div class="col-md-8">

								<sf:textarea path="description" id="description" rows="4"
									placeholder="Write a description here" class="form-control"></sf:textarea>
								<sf:errors path="description" style="color: #ff0000;"
									element="em" />
							</div>

						</div>
						<div class="form-group">

							<label class="control-label col-md-4" for="unitPrice">Enter
								Unit Prize: </label>

							<div class="col-md-8">

								<sf:input type="number" path="unitPrice" id="unitPrice"
									placeholder="Unit Price in &#8377" class="form-control" />
								<sf:errors path="unitPrice" style="color: #ff0000;" element="em" />
							</div>

						</div>

						<div class="form-group">

							<label class="control-label col-md-4" for="quantity">Enter
								Quantity Available: </label>

							<div class="col-md-8">

								<sf:input type="number" path="quantity" id="quantity"
									placeholder="Quantity Available" class="form-control" />
								<!--<em style="color: #ff0000">Please enter Quantity Available!</em>-->

							</div>

						</div>

						<!-- File element for image upload -->
						<div class="form-group">

							<label class="control-label col-md-4" for="file">Select
								an Image: </label>

							<div class="col-md-8">

								<sf:input type="file" path="file" id="file" class="form-control" />
								<sf:errors path="file" style="color: #ff0000;" element="em" />

							</div>

						</div>

						<div class="form-group">

							<label class="control-label col-md-4" for="categoryId">Select
								Category: </label>

							<div class="col-md-8">

								<sf:select class="form-control" path="categoryId"
									id="categoryId" items="${categories}" itemLabel="name"
									itemValue="id" />

								<c:if test="${product.id == 0}">
									<br />
									<div class="text-right">
										<button type="button" data-togggle="modal"
											data-target="myCategoryModal" class="btn btn-warning btn-xs">Add
											Category</button>
									</div>
								</c:if>


							</div>

						</div>


						<div class="form-group">

							<div class="col-md-offset-4 col-md-8">

								<input type="submit" name="submit" id="submit" value="Submit"
									class="btn btn-primary" />
								<!--  Hidden field for not changing values after edit form -->
								<sf:hidden path="id" />
								<sf:hidden path="code" />
								<sf:hidden path="supplierId" />
								<sf:hidden path="active" />
								<sf:hidden path="purchases" />
								<sf:hidden path="views" />


							</div>

						</div>

					</sf:form>

				</div>

			</div>

		</div>

	</div>


	<div class="row">

		<div class="col-xs-12">
			<h3>Available Products</h3>
		</div>

		<div class="col-xs-12">
			<div style="overflow: auto">

				<table id="adminProductsTable"
					class="table table-condensed table-bordered">

					<thead>
						<tr>
							<th>Id</th>
							<th>&#160;</th>
							<th>Name</th>
							<th>Brand</th>
							<th>Qty. Avail</th>
							<th>Unit Price</th>
							<th>Activate</th>
							<th>Edit</th>
						</tr>
					</thead>

					<!--  <tbody>

						<tr>
							<td>4</td>
							<td><img class="adminDataTableImg" style="height:50px;"
								src="${contextRoot}/resources/images/PRDMNO123PQRX.jpg"
								alt="Macbook Pro" /></td>
							<td>Macbook Pro</td>
							<td>Apple</td>
							<td>3</td>
							<td>&#8377; 54000.00/-</td>
							<td>
							 <label class="switch"> <input
									type="checkbox" checked="checked" value="4" />
									<div class="slider"></div>
							</label>
							</td>
							<td><a href="${contextRoot}/manage/4/product"
								class="btn btn-outline-primary"> <i class="fa fa-fw fa-edit"></i>
							</a></td>
						</tr>


						<tr>
							<td>4</td>
							<td><img class="adminDataTableImg" style="height:50px;"
								src="${contextRoot}/resources/images/PRDMNO123PQRX.jpg"
								alt="Macbook Pro" /></td>
							<td>Macbook Pro</td>
							<td>Apple</td>
							<td>3</td>
							<td>&#8377; 54000.00/-</td>
							<td>
								
					<label class="switch"> <input type="checkbox" value="4" />
						<div class="slider"></div>
					</label>
					</td>
					<td><a href="${contextRoot}/manage/4/product"
						class="btn btn-outline-primary"> <i class="fa fa-fw fa-edit"></i>
					</a></td>
					</tr>
					</tbody>
					-->
					<tfoot>
						<tr>
							<th>Id</th>
							<th>&#160;</th>
							<th>Name</th>
							<th>Brand</th>
							<th>Qty. Avail</th>
							<th>Unit Price</th>
							<th>Activate</th>
							<th>Edit</th>
						</tr>
					</tfoot>


				</table>

			</div>
		</div>

	</div>


	<div class="modal fade" id="myCategoryModal" role="dialog"
		tabindex="-1">

		<div class="modal-dialog" role="document">

			<div class="modal-content">
				<!-- Modal Header -->
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">
						<span>&times;</span>
					</button>
					<h4 class="modal-title">Add New Category</h4>
				</div>
				<div class="modal-body">
					<!-- Category Form -->
				</div>

			</div>

		</div>

	</div>

</div>