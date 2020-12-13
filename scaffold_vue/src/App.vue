<template>
  <div id="app">
    <img alt="Vue logo" src="./assets/logo.png">
    <HelloWorld msg="Welcome to Your Vue.js App"/>


    <div>
      <table>
        <tbody>
        <tr>
          <td>

          </td>
        </tr>
        </tbody>
      </table>
    </div>

  </div>



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
      clientes : null
    }
  },

  mounted() {
    console.log('Hola vue desde mounted')
    this.getClientes();
  },

  methods:{
    getClientes(){
      console.log('aca va el codigo de get clientes')
      axios
        .get('http://localhost:3000/apiclientes')
          .then( response => {
            console.log(response)

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
