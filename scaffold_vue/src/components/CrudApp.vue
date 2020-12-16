<template>
  <div style="margin: 0 auto; width: 100%">
    <Panel header="Listado Clientes">
      <Menubar :model="items" />
      <br />
      <DataTable :value="clientes " :paginator="true" :rows="10" selectionMode="single " :selection.sync="selectedCliente" dataKey="numeroDocumento">
               <Column field="numeroDocumento" header="NumeroDocumento"></Column>
                <Column field="nombre" header="Nombre"></Column>
                <Column field="tipoDocumento" header="TipoDocumento"></Column>
                <Column field="correo" header="Correo"></Column>
                <Column field="direccion" header="Direccion"></Column>
                <Column field="telefonoFijo" header="TelefonoFijo"></Column>
                <Column field="celular" header="Celular"></Column>
      </DataTable>
    </Panel>
    <Dialog header="Crear Cliente" :visible.sync="displayModal" :modal="true">
      <span class="p-float-label">
        <InputText id="numeroDocumento" type="text" v-model="cliente.numeroDocumento" style="width: 100%" />
        <label for="numeroDocumento">NumeroDocumento</label>
      </span>
      <br />
      <span class="p-float-label">
        <InputText id="nombre" type="text" v-model="cliente.nombre" style="width: 100%" />
        <label for="nombre">Nombre</label>
      </span>
      <br />
      <span class="p-float-label">
        <InputText id="tipoDocumento" type="text" v-model="cliente.tipoDocumento" style="width: 100%" />
        <label for="tipoDocumento">TipoDocumento</label>
      </span>
      <br />
      <span class="p-float-label">
        <InputText id="correo" type="text" v-model="cliente.correo" style="width: 100%" />
        <label for="correo">Correo</label>
      </span>
      <br />
      <span class="p-float-label">
        <InputText id="direccion" type="text" v-model="cliente.direccion" style="width: 100%" />
        <label for="direccion">Dirección</label>
      </span>
      <br />
      <span class="p-float-label">
        <InputText id="telefonoFijo" type="text" v-model="cliente.telefonoFijo" style="width: 100%" />
        <label for="telefonoFijo">Telefono</label>
      </span>
      <br />
      <span class="p-float-label">
        <InputText id="celular" type="text" v-model="cliente.celular" style="width: 100%" />
        <label for="celular">Celular</label>
      </span>
      <template #footer>
        <Button label="Guardar" icon="pi pi-check" @click="save" />
        <Button label="Cancelar" icon="pi pi-times" @click="closeModal" class="p-button-secondary" />
      </template>
    </Dialog>
  </div>
</template>

<script>
import ClienteService from "../service/ClienteService";
export default {
  name: "CrudApp",
  data() {
    return {
      clientes: null,
      cliente: {
        numeroDocumento: null,
        nombre: null,
        tipoDocumento: null,
        correo: null,
        direccion: null,
        telefono: null,
        celular: null
      },
      selectedCliente : {
        numeroDocumento: null,
        nombre: null,
        tipoDocumento: null,
        correo: null,
        direccion: null,
        telefono: null,
        celular: null
      },
      items: [
        {
          label: "Nuevo",
          icon: "pi pi-fw pi-plus",
          command: () => {
            this.showSaveModal();
          }
        },
        {
          label: "Editar",
          icon: "pi pi-fw pi-pencil",
          comand: () =>{
            this.showEditModal();
          }
        },
        {
          label: "Eliminar",
          icon: "pi pi-fw pi-trash"
        },
        {
          label: "Refrescar",
          icon: "pi pi-fw pi-refresh",
          command: () => {
            this.getAll();
          }
        }
      ],
      displayModal: false
    };
  },
  clienteService: null,
  created() {
    this.clienteService = new ClienteService();
  },
  mounted() {
    this.getAll();
  },
  methods: {
    showSaveModal() {
      this.displayModal = true;
    },
    showEditModal() {
      this.cliente = this.selectedCliente;
      this.displayModal = true;
    },
    getAll() {
      this.clienteService.getAll().then(data => {
        this.clientes = data.data;
      });
    },
    save() {
      this.clienteService.save(this.cliente).then(data => {
        if (data.status === 200) {
          this.displayModal = false;
          this.cliente = {
            numeroDocumento: null,
            nombre: null,
            tipoDocumento: null,
            correo: null,
            direccion: null,
            telefono: null,
            celular: null,
          };
          this.getAll();
        }
      });
    },
    closeModal() {
      this.displayModal = false;
    }
  }
};
</script>

<style>
</style>