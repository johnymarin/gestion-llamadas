<template>
  <div id="app">
    <img alt="Vue logo" src="./assets/logo.png">
    <HelloWorld msg="SOLICITUDES"/>

/*
 numerodeRadicado;
    String motivo;
     descripcion;
     estado;
     tiempoMaximoDerespuesta;
     evento;
}*/


  <div>
      <table>
          <tbody>
            <tr>SOLICITUD</tr>
                <td>{{Solicitud.numerodeRadicado}}</td>
                <td>{{Solicitud.motivo}}</td>
                <td>{{Solicitud.descripcion}}</td>
                <td>{{Solicitud.estado}}</td>
                <td>{{Solicitud.tiempoMaximoDerespuesta}}</td>
                <td>{{Solicitud.evento}}</td>
            <tr>CAMBIAR ESTADO POR:</tr>
            <input class="add-search-input"
              type="text"
              v-model="newEstado"
              @keyup.enter="cambiarestadoSolicitud">

            <tr>OBTENER SOLICITUD POR ID:</tr>
             <input class="add-search-input"
                   type="text"
                   v-model="soli"
                   @keyup.space="getSolicitud">
          </tbody>
      </table>
  </div>

  </div>

save chek ok

</template>

<script>
import HelloWorld from './components/HelloWorld.vue'
import axios from 'axios'


export default {
  name: 'App',
  components: {
    HelloWorld
  },

  data(){
    return{
      Solicitud : null,
      newEstado:'',
      soli:'',
    }
  },

  mounted() {
    console.log('Hola vue desde Solicitudes')
   // this.getSolicitud();
    // this.cambiarestadoSolicitud();
  },

  methods:{
    getSolicitud(){
      console.log('aca va el codigo de get clientes')
      axios
        .get('http://localhost:3000/solicitudes',{numerodeRadicado:this.soli})
          .then( response => {
            console.log(response)
            this.Solicitud=response.data
            this.soli='';
          })
        .catch( e=> console.log(e))
    },
    cambiarestadoSolicitud(){
      console.log('aca va el codigo dPARA CAMBIAR SOLICITUD')
      axios.post('http://localhost:3000/solicitudes',{estado:this.newEstado})
          .then( response => {
            const data =response.data;
            this.Solicitud.push(data);
            this.newEstado='';
            console.log(response)
            this.Solicitud=response.data
          })
          .catch( e=> console.log(e))
    }
  }

}
</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
</style>
