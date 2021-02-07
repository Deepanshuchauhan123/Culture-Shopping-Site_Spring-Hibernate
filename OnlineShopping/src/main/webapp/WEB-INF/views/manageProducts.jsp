<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<div class="container">

	<div class="row">
	<div class="col-xs-12">
	
	
	</div>

		<div class="col-md-offset-2 col-md-8">

			<div class="panel panel-primary">

				<div class="panel-heading">

					<h4>Product Management</h4>

				</div>
				<div class="panel-body">

					<!-- Form Elements -->
					<sf:form class="form-horizontal" modelAttribute="product"
						action="${contextRoot}/manage/products" method="POST">

						<div class="form-group">

							<label class="control-label col-md-4" for="name">Enter
								Product Name: </label>

							<div class="col-md-8">

								<sf:input type="text" path="name" id="name"
									placeholder="Product Name" class="form-control" />
								<em class="help-block" style="color: #ff0000">Please enter
									Product Name!</em>

							</div>

						</div>

						<div class="form-group">

							<label class="control-label col-md-4" for="brand">Enter
								Brand Name: </label>

							<div class="col-md-8">

								<sf:input type="text" path="brand" id="brand"
									placeholder="Brand Name" class="form-control" />
								<em style="color: #ff0000">Please enter Brand Name!</em>

							</div>

						</div>

						<div class="form-group">

							<label class="control-label col-md-4" for="description">Product
								Description: </label>

							<div class="col-md-8">

								<sf:textarea path="description" id="description" rows="4"
									placeholder="Write a description here" class="form-control"></sf:textarea>

							</div>

						</div>
						<div class="form-group">

							<label class="control-label col-md-4" for="unitPrice">Enter
								Unit Prize: </label>

							<div class="col-md-8">

								<sf:input type="number" path="unitPrice" id="unitPrice"
									placeholder="Unit Price in &#8377" class="form-control" />
								<em style="color: #ff0000">Please enter Unit Price!</em>

							</div>

						</div>

						<div class="form-group">

							<label class="control-label col-md-4" for="quantity">Enter
								Quantity Available: </label>

							<div class="col-md-8">

								<sf:input type="number" path="quantity" id="quantity"
									placeholder="Quantity Available" class="form-control" />
								<em style="color: #ff0000">Please enter Quantity Available!</em>

							</div>

						</div>

						<div class="form-group">

							<label class="control-label col-md-4" for="categoryId">Select
								Category: </label>

							<div class="col-md-8">

								<sf:select path="categoryId" id="categoryId"
									items="${categories}" itemLabel="name" itemValue="id" />
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

</div>