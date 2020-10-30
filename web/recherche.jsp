
<%@page import="garage.razafindramasy.Reparation"%>
<%@page import="garage.amby.ReparationServlet"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<% 
   
    Reparation [] rep=(Reparation[])request.getAttribute("all_reps");
    
%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <title>Admin VONJY 3F | Tableau de bord</title>
  <!-- Tell the browser to be responsive to screen width -->
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <!-- Font Awesome -->
  <link rel="stylesheet" href="admin/plugins/fontawesome-free/css/all.min.css">
  <!-- Ionicons -->
  <link rel="stylesheet" href="https://code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css">
  <!-- Tempusdominus Bbootstrap 4 -->
  <link rel="stylesheet" href="admin/plugins/tempusdominus-bootstrap-4/css/tempusdominus-bootstrap-4.min.css">
  <!-- iCheck -->
  <link rel="stylesheet" href="admin/plugins/icheck-bootstrap/icheck-bootstrap.min.css">
  <!-- JQVMap -->
  <link rel="stylesheet" href="admin/plugins/jqvmap/jqvmap.min.css">
  <!-- Theme style -->
  <link rel="stylesheet" href="admin/dist/css/adminlte.min.css">
  <!-- overlayScrollbars -->
  <link rel="stylesheet" href="admin/plugins/overlayScrollbars/css/OverlayScrollbars.min.css">
  <!-- Daterange picker -->
  <link rel="stylesheet" href="admin/plugins/daterangepicker/daterangepicker.css">
  <!-- summernote -->
  <link rel="stylesheet" href="admin/plugins/summernote/summernote-bs4.css">
  <!-- Google Font: Source Sans Pro -->
  <link href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700" rel="stylesheet">
</head>
<body>
<!-- Navbar -->
   <nav class="navbar navbar-expand-lg navbar-light bg-dark">
            <div class="collapse navbar-collapse" id="navbarNav">
                <ul class="navbar-nav">
		    <li class="nav-item active">
		       	<a class="nav-link" href="repa" style="color: white;">Accueil<span class="sr-only"></a>
		    </li>
                    <li class="nav-item active">
		       	<a class="nav-link" href="client" style="color: orange;">Ajout de reparation<span class="sr-only"></a>
		    </li>
		</ul>   
            </div>
	</nav>
  <!-- /.navbar -->
  <br>

   <section class="content">
      <div class="container-fluid">
        <div class="row">
          <!-- left column -->
          <div class="col-md-12">
            <div class="card">
              <div class="card-header">
                <h3 class="card-title">Liste des reparations</h3>

                <div class="card-tools">
                    <form action="fiche" method="GET">
                        <div class="input-group input-group-sm" style="width: 150px;">
                          <input type="text" name="etat" class="form-control float-right" placeholder="Search">

                          <div class="input-group-append">
                            <button type="submit" class="btn btn-default"><i class="fas fa-search"></i></button>
                          </div>
                        </div>
                    </form>
                </div>
              </div>
              <!-- /.card-header -->
              <div class="card-body table-responsive p-0">
                <table class="table ">
                  <thead>
                    <tr>
                      <th>Marque Voiture</th>
                      <th>N Matricule</th>
                      <th>Nom Client</th>
                      <th>Tel Client</th>
                      <th>Reparation</th>
                      <th>Date</th>
                      <th>Etat Rep</th>
                      <th>Terminer Rep</th>
                      <th>Modifier</th>
                      <th>Supprimer</th>
                      <th>Facture</th>
                    </tr>
                  </thead>
                  <tbody>
                    <%for(int u=0;u<rep.length;u++){%>  
                    <tr>
                      <td><%out.println(rep[u].makavoiture().get_marqueVoiture());%></td>
                      <td><%out.println(rep[u].makavoiture().get_numero());%></td>
                      <td><%out.println(rep[u].makavoiture().makaclient().get_nomClient());%></td>
                      <td><%out.println(rep[u].makavoiture().makaclient().get_tel());%></td>
                      <td><%out.println(rep[u].get_typedeRepar());%></td>
                      <td><%out.println(rep[u].get_daterep());%> </td>
                      <td>
                            <%if(rep[u].get_etatrep().compareTo("0")==0){%>
                                <div class="progress progress-sm active">
                                    <div class="progress-bar bg-primary progress-bar-striped" role="progressbar"
                                       aria-valuenow="40" aria-valuemin="0" aria-valuemax="100" style="width: 40%">
                                        <span class="sr-only">40% Complete (success)</span>
                                    </div>
                                </div>
                            <%}else{%>
                                <div class="progress progress-sm ">
                                    <div class="progress-bar bg-primary progress-bar-striped" role="progressbar"
                                        aria-valuenow="40" aria-valuemin="0" aria-valuemax="100" style="width: 100%">
                                        <span class="sr-only">40% Complete (success)</span>
                                    </div>
                                </div>
                            <%}%>
                      </td>
                      <%if(rep[u].get_etatrep().compareTo("0")==0){%>
                        <td><a href="update.jsp?id=<%out.print(rep[u].get_idR());%>"><span class="badge bg-primary">Terminer</span></a></td>
                        <td><a href="#"><span class="badge bg-success">Modifier</span></a></td>
                        <td><a href="delete.jsp?id=<%out.print(rep[u].get_idR());%>&id1=<%out.print(rep[u].makavoiture().get_idV());%>"><span class="badge bg-danger">Supprimer</span></a></td>
                        <td>Non Facturer</td>
                      <%}else{%>
                        <td>Terminer</span></a></td>
                        <td>Modifier</span></a></td>
                        <td>Supprimer</span></a></td>
                        <td><a href="#"><span class="badge bg-primary">Facturer</span></a></td>
                       <%}%>
                    </tr>
                    <%}%>
                  </tbody>
                </table>
              </div>
              <!-- /.card-body -->
              <div class="card-footer clearfix">
                <ul class="pagination pagination-sm m-0 float-right">
                  <% int occ=rep[0].getoccu(3);
                    for(int i=1;i<occ+1;i++){
                  %>  
                  <li class="page-item"><a class="page-link" href="repa?nbr=<%out.print(i-1);%>"><%out.print(i);%></a></li>
                  <%}%>
                </ul>
              </div>
            </div>
            <!-- /.card -->
          </div>
        </div>
      </div>
    </section>
  </div>

  <!-- jQuery -->
<script src="../admin/plugins/jquery/jquery.min.js"></script>
<!-- jQuery UI 1.11.4 -->
<script src="../admin/plugins/jquery-ui/jquery-ui.min.js"></script>
<!-- Resolve conflict in jQuery UI tooltip with Bootstrap tooltip -->
<script>
  $.widget.bridge('uibutton', $.ui.button)
</script>
<!-- Bootstrap 4 -->
<script src="../admin/plugins/bootstrap/js/bootstrap.bundle.min.js"></script>
<!-- ChartJS -->
<script src="../admin/plugins/chart.js/Chart.min.js"></script>
<!-- Sparkline -->
<script src="../admin/plugins/sparklines/sparkline.js"></script>
<!-- JQVMap -->
<script src="../admin/plugins/jqvmap/jquery.vmap.min.js"></script>
<script src="../admin/plugins/jqvmap/maps/jquery.vmap.usa.js"></script>
<!-- jQuery Knob Chart -->
<script src="../admin/plugins/jquery-knob/jquery.knob.min.js"></script>
<!-- daterangepicker -->
<script src="../admin/plugins/moment/moment.min.js"></script>
<script src="../admin/plugins/daterangepicker/daterangepicker.js"></script>
<!-- Tempusdominus Bootstrap 4 -->
<script src="../admin/plugins/tempusdominus-bootstrap-4/js/tempusdominus-bootstrap-4.min.js"></script>
<!-- Summernote -->
<script src="../admin/plugins/summernote/summernote-bs4.min.js"></script>
<!-- overlayScrollbars -->
<script src="../admin/plugins/overlayScrollbars/js/jquery.overlayScrollbars.min.js"></script>
<!-- AdminLTE App -->
<script src="../admin/dist/js/adminlte.js"></script>
<!-- AdminLTE dashboard demo (This is only for demo purposes) -->
<script src="../admin/dist/js/pages/dashboard.js"></script>
<!-- AdminLTE for demo purposes -->
<script src="../admin/dist/js/demo.js"></script>
</body>
</html>