<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<div align="center">
	<html:form action="/saveUser.do" method="post">
		<pre>
Select date:  <input type="date" id="mon"><br> <html:hidden
				property="month" value="" />
			<br>
 
Select Project  :<select id="pname"><option value="0">select Project</option></select>&nbsp;

Project Name :<html:text property="projectname" size="30"
				maxlength="120" /> <br>
Project ID : <html:text property="prjectid" size="30" maxlength="120" />unique auto generater value <br>
Project Detail :<html:text property="projectdetail" size="30"
				maxlength="120" /> <br>
Created By :<html:text property="created" size="30" maxlength="120" /> <br>
Started Date : <input type="date" id="sdate">
			<html:hidden property="stratdate" /> <br>
End Date : <input type="date" id="edate">
			<html:hidden property="enddate" /> <br>
Status :<html:text property="status" size="30" maxlength="120" /> <br>
 </pre>
		<html:submit property="operation" value="Create">Create</html:submit>
		<html:submit property="operation" value="Update">Update</html:submit>
		<html:submit property="operation" value="Delete">Delete</html:submit>
		<input type="reset" value="Reset">
	</html:form>
</div>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script type="text/javascript">
	$(document).ready(
			function() {
				$('#mon').change(function() {
					var month = $(this).val();
					$('[name=month]').val(month);
				});
				$('#sdate').change(function() {
					var sdate = $(this).val();
					$('[name=stratdate]').val(sdate);
				});
				$('#edate').change(function() {
					var edate = $(this).val();
					$('[name=enddate]').val(edate);
				});

				$('#mon').change(
						function() {
							var month1 = $('[name=month]').val();
							$.ajax({
								type : "POST",
								url : "date.do",
								data : "date=" + month1,
								success : function(response) {
									var res = response.split(",");
									$('#pname').children('option:not(:first)')
											.remove();
									if (response != "") {
										for (i = 0; i < res.length; i++) {
											if (res[i] != "") {
												$("#pname").append(
														'<option value='+res[i]+'>'
																+ res[i]
																+ '</option>');
											}
										}
									}
								}
							});
						});

				$('#pname').change(function() {
					var name = $('#pname').val();
					$.ajax({
						type : "POST",
						url : "getdetail.do",
						data : "name=" + name,
						success : function(response1) {
							var response = response1.split(",");
							$('#mon').val(response[0]);
							$('[name=projectname]').val(response[1]);
							$('[name=prjectid]').val(response[2]);
							$('[name=projectdetail]').val(response[3]);
							$('[name=created]').val(response[4]);
							$('#sdate').val(response[5]);
							$('#edate').val(response[6]);
							$('[name=status]').val(response[7]);
						}
					});
				});

			});
</script>