<template>
  <v-app>
    <v-container fluid class="pa-0 ma-0" >
    <v-tabs class="header " background-color="rgba(0, 0, 0,0)" color="white">
    <div class="col-md-2 gohome">
      <a dark href="/" id="gohome"  
      class="red--text text-h3 font-weight-black">
      NETFLIX
      </a>
    </div>
    <v-tabs-slider color="rgba(0, 0, 0,0)"></v-tabs-slider> 
    <v-tab  v-for="item in items"
        :key="item.id"
        class="no-gutters col-md-2 text-h4 font-weight-black white--text" 
        :to="item.to"
        >
      {{item.title}}
    </v-tab>
    <div class="col-md-2 login">
      <v-btn 
      to="/" 
      id="login"
      class="text-h4 font-weight-black">
          login
      </v-btn>
    </div>
    </v-tabs>
    

       <v-main class="">
    <v-content class="">
        <router-view class="pa-0 ma-0"/>
    </v-content>
  </v-main> 
  </v-container> 
</v-app>
</template>

<script>
export default {
  name: 'App',

  components: {
    
  },
 

  data: () => ({
    //
    
    items: [
          { id:1,title: '리뷰', to:'/movieList' },
          { id:2,title: '게시판', to:'/board'},
          { id:3,title: '뉴스', to:'/news'},
          { id:4,title: '함께 봐요', to:'/together' },
          { id:5,title: '실시간 순위', to:'/'},
          ],
        right: null,
  }),
};
</script>
<style>

* {
  box-sizing: border-box;
  font-family: 'Bebas Neue';
} 
.container{
  display: inline;
  background-color: black;
}
/* .v-main{
  display:inline;
} */
.header {
  margin: 0px;
  padding: 0px;
  width: 100%;
  position: fixed;
  display: absolute;
  top: 0;
  left: 0;
  z-index: 3;
}
#goHome {
  width: 100%;
  height: 48px;
  padding: 0px;
  margin-bottom: 10px;
  
}
.gohome {
  color: red;
  padding: 0px;
   height: 48px;
}


.col-md-2.login{
  padding: 7px;
  text-align: center; 
  margin-top:0;
  /* background-color:rgba(0, 0, 255, 0)  !important;
    
    border-color: rgba(0, 0, 255, 1); */
    border: none;
    outline: 0;
    margin: -2px;
}
.col-md-2.gohome{
  padding-top: 0px;
}

.row{
  display: flex;
  margin: 0px;
  
}
a { text-decoration:none;
 /* padding: 3px; */
 } 
/* .v-content {
  margin-bottom: 10px;
  
} */

/* material-light{
  v-tab: rgba(0, 0, 0, 0.54) ;
}  */

</style>
