(window["webpackJsonpguismi-app"]=window["webpackJsonpguismi-app"]||[]).push([[0],{104:function(e,t,a){},105:function(e,t,a){},155:function(e,t,a){},156:function(e,t,a){},159:function(e,t,a){"use strict";a.r(t);var n=a(0),i=a.n(n),c=a(20),s=(a(104),a(6)),r=a(7),l=a(11),o=a(9),d=a(10),h=(a(105),a(97)),u=a(33),m=a(88),f=a(31),p=function(){function e(){Object(s.a)(this,e),this.headers=void 0,this.headers=new Headers,this.headers.append("Content-Type","application/json")}return Object(r.a)(e,null,[{key:"getMyHeaders",value:function(){return null!==this._myHeaders&&void 0!==this._myHeaders||(this._myHeaders=new e),this._myHeaders.headers}},{key:"addHeader",value:function(e,t){return this._myHeaders.headers.append(e,t),this._myHeaders}},{key:"resetMyHeaders",value:function(){this._myHeaders=new e}}]),e}();p._myHeaders=void 0;var b={login:function(e,t){var a={method:"POST",headers:{"Content-Type":"application/json"},body:JSON.stringify({username:e,password:t}),credentials:"include"};return fetch("/api/auth/callback",a).then((function(e){return e})).then(v).then((function(a){return a&&(a.authdata=window.btoa(e+":"+t),localStorage.setItem("user",JSON.stringify(a))),a}))},logout:E};function E(){localStorage.removeItem("user")}function v(e){return e.then((function(e){return p.getMyHeaders(),e})).text().then((function(t){var a=t&&JSON.parse(t);if(!e.ok){401===e.status&&E();var n=a&&a.message||e.statusText;return Promise.reject(n)}return a}))}var y=a(15),g=a.n(y),O=a(28),j=a.n(O),S=a(37),k=a.n(S),C=function(e){function t(e){var a;return Object(s.a)(this,t),(a=Object(l.a)(this,Object(o.a)(t).call(this,e))).state={username:"",password:"",submitted:!1,loading:!1,error:""},a.handleChange=a.handleChange.bind(Object(f.a)(a)),a.handleSumit=a.handleSumit.bind(Object(f.a)(a)),a}return Object(d.a)(t,e),Object(r.a)(t,[{key:"handleChange",value:function(e){var t=e.target,a=t.name,n=t.value;this.setState(Object(m.a)({},a,n))}},{key:"handleSumit",value:function(e){var t=this;e.preventDefault(),this.setState({submitted:!0});var a=this.state,n=a.username,i=a.password;b.login(n,i).then((function(e){window.location.hash="#/escolhe_ficha"}),(function(e){return t.setState({error:e,loading:!1})})),window.location.hash="#/escolhe_ficha"}},{key:"render",value:function(){return i.a.createElement(k.a,null,i.a.createElement(g.a,{onSubmit:this.handleSumit},i.a.createElement(g.a.Group,{controlId:"formBasicUsername"},i.a.createElement(g.a.Label,{column:!1},"Username"),i.a.createElement(g.a.Control,{type:"text",placeholder:"Enter username",name:"username",onChange:this.handleChange}),i.a.createElement(g.a.Text,{className:"text-muted"})),i.a.createElement(g.a.Group,{controlId:"formBasicPassword"},i.a.createElement(g.a.Label,{column:!1},"Password"),i.a.createElement(g.a.Control,{type:"password",placeholder:"Password",name:"password",onChange:this.handleChange})),i.a.createElement(j.a,{variant:"primary",type:"submit"},"Submit")))}}]),t}(i.a.Component),w=a(89),D=a.n(w),_=a(29),F=a.n(_),I=a(19),x=a.n(I),P=a(48),H=a.n(P),N=a(56),z=a.n(N),A=a(34),J=a.n(A),T=function(e){function t(){return Object(s.a)(this,t),Object(l.a)(this,Object(o.a)(t).apply(this,arguments))}return Object(d.a)(t,e),Object(r.a)(t,[{key:"render",value:function(){return i.a.createElement(H.a,{vertical:!0},i.a.createElement(j.a,null,"Button"),i.a.createElement(j.a,null,"Button"),i.a.createElement(z.a,{as:H.a,title:"Dropdown",id:"bg-vertical-dropdown-1"},i.a.createElement(J.a.Item,{eventKey:"1"},"Dropdown link"),i.a.createElement(J.a.Item,{eventKey:"2"},"Dropdown link")),i.a.createElement(j.a,null,"Button"),i.a.createElement(j.a,null,"Button"),i.a.createElement(z.a,{as:H.a,title:"Dropdown",id:"bg-vertical-dropdown-2"},i.a.createElement(J.a.Item,{eventKey:"1"},"Dropdown link"),i.a.createElement(J.a.Item,{eventKey:"2"},"Dropdown link")),i.a.createElement(z.a,{as:H.a,title:"Dropdown",id:"bg-vertical-dropdown-3"},i.a.createElement(J.a.Item,{eventKey:"1"},"Dropdown link"),i.a.createElement(J.a.Item,{eventKey:"2"},"Dropdown link")))}}]),t}(i.a.Component),B=function(e){function t(e){var a;return Object(s.a)(this,t),(a=Object(l.a)(this,Object(o.a)(t).call(this,e))).state={ficha:a.props.ficha,plaintext:!0,readOnly:!0},a.onClick=a.onClick.bind(Object(f.a)(a)),a}return Object(d.a)(t,e),Object(r.a)(t,[{key:"componentDidUpdate",value:function(e){e.ficha.nomePersonagem!==this.props.ficha.nomePersonagem&&this.setState({ficha:this.props.ficha})}},{key:"onClick",value:function(){this.setState({plaintext:!1,readOnly:!1})}},{key:"onBlur",value:function(){this.setState({plaintext:!0,readOnly:!0})}},{key:"render",value:function(){return i.a.createElement(g.a.Control,{type:"text",defaultValue:this.state.ficha.nomePersonagem,plaintext:this.state.plaintext,readOnly:this.state.readOnly,onDoubleClick:this.onClick,onBlur:this.onBlur.bind(this)})}}]),t}(i.a.Component),R=function(){function e(){Object(s.a)(this,e),this._racas=void 0,this._caminhos=[],this._cidades=void 0,this._descendencias=void 0,this._habilidades=void 0,this._habitos=void 0,this._idiomas=void 0,this._patronos=void 0,this._especializacoes=void 0;var t=localStorage.getItem("sistema");t?this.setSistemaFromObject(JSON.parse(t)):this.sistemaGetRequest()}return Object(r.a)(e,[{key:"sistemaGetRequest",value:function(){var e=this;fetch("api/sistema",{method:"GET",headers:p.getMyHeaders(),credentials:"include"}).then((function(e){return e.json()})).then((function(t){localStorage.setItem("sistema",JSON.stringify(t)),e.setSistemaFromObject(t)}))}},{key:"setSistemaFromObject",value:function(e){this._racas=e.racas,this._caminhos=e.caminhos,this._cidades=e.cidades,this._descendencias=e.descendencias,this._habilidades=e.habilidades,this._habitos=e.habitos,this._idiomas=e.idiomas,this._patronos=e.patronos,this._especializacoes=e.especializacoes}},{key:"racas",get:function(){return void 0!==this._racas?this._racas:[]}},{key:"caminhos",get:function(){return void 0!==this._caminhos?this._caminhos:[]}},{key:"cidades",get:function(){return void 0!==this._cidades?this._cidades:[]}},{key:"descendencias",get:function(){return void 0!==this._descendencias?this._descendencias:[]}},{key:"especializacoes",get:function(){return void 0!==this._especializacoes?this._especializacoes:[]}},{key:"habilidades",get:function(){return void 0!==this._habilidades?this._habilidades:[]}},{key:"habitos",get:function(){return void 0!==this._habitos?this._habitos:[]}},{key:"idiomas",get:function(){return void 0!==this._idiomas?this._idiomas:[]}},{key:"patronos",get:function(){return void 0!==this._patronos?this._patronos:[]}}],[{key:"sistema",get:function(){return void 0===this._sistema&&(this._sistema=new e),this._sistema}}]),e}();R._sistema=void 0;var U=function(e){function t(e){var a;return Object(s.a)(this,t),(a=Object(l.a)(this,Object(o.a)(t).call(this,e))).state={ficha:a.props.ficha,sistema:R.sistema},a.handleChange=a.handleChange.bind(Object(f.a)(a)),a}return Object(d.a)(t,e),Object(r.a)(t,[{key:"handleChange",value:function(e){this.setState((function(t){return t.ficha.idRaca=Number(e.target.value),{ficha:t.ficha}})),this.render()}},{key:"componentDidUpdate",value:function(e,t){e.ficha.raca!==this.props.ficha.raca&&this.setState({ficha:this.props.ficha})}},{key:"render",value:function(){return i.a.createElement(g.a.Group,null,i.a.createElement(g.a.Label,{column:!1},"Raca"),i.a.createElement(g.a.Control,{value:this.state.ficha.idRaca.toString(),as:"select",onChange:this.handleChange},this.state.sistema.racas.map((function(e){return i.a.createElement("option",{key:e.idRaca,value:e.idRaca},e.nomeRaca)}))))}}]),t}(i.a.Component),M=function(e){function t(e){var a;return Object(s.a)(this,t),(a=Object(l.a)(this,Object(o.a)(t).call(this,e))).state={caminho:a.props.caminho,caminhosSistema:R.sistema.caminhos},a}return Object(d.a)(t,e),Object(r.a)(t,[{key:"handleChange",value:function(e){var t=e.target.value;this.setState((function(e){return e.caminho.idCaminho=Number(t),{caminho:e.caminho}}))}},{key:"render",value:function(){return n.createElement(g.a.Control,{as:"select",value:this.state.caminho.idCaminho.toString(),onChange:this.handleChange.bind(this)},this.state.caminhosSistema.map((function(e,t){return n.createElement("option",{key:t,value:e.idCaminho},e.nomeCaminho)})))}}]),t}(n.Component),G=function(e){function t(e){var a;return Object(s.a)(this,t),(a=Object(l.a)(this,Object(o.a)(t).call(this,e))).caminhoOptions=void 0,a.state={ficha:a.props.ficha,sistema:R.sistema,isInvalid:[]},a}return Object(d.a)(t,e),Object(r.a)(t,[{key:"componentDidMount",value:function(){this.caminhoOptions=this.state.sistema.caminhos.map((function(e){return n.createElement("option",{key:e.idCaminho,value:e.idCaminho},e.nomeCaminho)})),this.setState((function(e){e.isInvalid.fill(!1,0,e.ficha.caminhos.length)})),this.handleChange=this.handleChange.bind(this)}},{key:"componentDidUpdate",value:function(e,t,a){JSON.stringify(e.ficha.caminhos)!==JSON.stringify(this.props.ficha.caminhos)&&this.setState({ficha:this.props.ficha})}},{key:"handleChange",value:function(e,t,a){}},{key:"render",value:function(){var e=this;return n.createElement(g.a.Group,null,n.createElement(g.a.Label,{column:!1},"Caminhos"),this.state.ficha.caminhos.map((function(t,a){return n.createElement(M,{key:a,caminho:t,ficha:e.state.ficha})})))}}]),t}(n.Component),K=a(50),L=a.n(K),W=function(e){function t(e){var a;return Object(s.a)(this,t),(a=Object(l.a)(this,Object(o.a)(t).call(this,e))).state={ficha:a.props.ficha,sistema:R.sistema},a}return Object(d.a)(t,e),Object(r.a)(t,[{key:"componentDidUpdate",value:function(e,t){JSON.stringify(e.ficha.habitos)!==JSON.stringify(this.props.ficha.habitos)&&this.setState({ficha:this.props.ficha})}},{key:"render",value:function(){return n.createElement(L.a,{hover:!0,size:"sm"},n.createElement("thead",{className:"thead-dark"},n.createElement("tr",null,n.createElement("th",null,"HABITOS"),n.createElement("th",null,"Quantidade"),n.createElement("th",null,"Mod5"),n.createElement("th",null,"Mod10"))),n.createElement("tbody",null,this.props.ficha.habitos.map((function(e){return n.createElement("tr",{key:e.idHabito},n.createElement("td",null,e.nomeHabito),n.createElement("td",null,e.qtdFichaHabito),n.createElement("td",null,e.qtdFichaHabito/5),n.createElement("td",null,e.qtdFichaHabito/10))}))))}}]),t}(n.Component),q=function(){function e(t){Object(s.a)(this,e),this.idFicha=void 0,this.idRaca=-1,this.idCidade=-1,this.idJogador=-1,this.nomePersonagem="",this.img="",this.idade=0,this.afiliacao="",this.cla="",this.sorteDia=-1,this.distForca=0,this.distConstituicao=0,this.distAgilidade=0,this.distDestreza=0,this.distInteligencia=0,this.distSabedoria=0,this.distCarisma=0,this.nivelPersonagem=1,this.expPersonagem=0,this.descPersonagem="",this.histPersonagem="",this.nota="",this.idSanidade=0,this.raca={},this.caminhos=[],this.descendencias=[],this.habilidades=[],this.habitos=[],this.idiomas=[],this.inventarios=[],this.patronos=[],this.situacoes=[],this.idFicha=t}return Object(r.a)(e,[{key:"getById",value:function(){var e=this;return fetch("api/ficha/id/"+this.idFicha,{method:"GET",headers:p.getMyHeaders()}).then((function(e){return e.json()})).then((function(t){e.setFichaFromObject(t)})),this}},{key:"update",value:function(){var e=this;fetch("api/ficha/",{method:"PUT",headers:p.getMyHeaders(),body:JSON.stringify(this)}).then((function(t){t.ok?console.log("Ficha "+e.idFicha+" atualizada com sucesso."):console.log("Status "+t.statusText)}))}},{key:"setFichaFromObject",value:function(e){this.idRaca=e.idRaca,this.idCidade=e.idCidade,this.idJogador=e.idJogador,this.nomePersonagem=e.nomePersonagem,this.img=e.img,this.idade=e.idade,this.afiliacao=e.afiliacao,this.cla=e.cla,this.sorteDia=e.sorteDia,this.distForca=e.distForca,this.distAgilidade=e.distAgilidade,this.distCarisma=e.distCarisma,this.distConstituicao=e.distConstituicao,this.distDestreza=e.distDestreza,this.distSabedoria=e.distSabedoria,this.distInteligencia=e.distInteligencia,this.nivelPersonagem=e.nivelPersonagem,this.expPersonagem=e.expPersonagem,this.descPersonagem=e.descPersonagem,this.histPersonagem=e.histPersonagem,this.nota=e.nota,this.idSanidade=e.idSanidade,this.raca=e.raca,this.caminhos=e.caminhos,this.descendencias=e.descendencias,this.habilidades=e.habilidades,this.habitos=e.habitos,this.idiomas=e.idiomas,this.inventarios=e.inventarios,this.patronos=e.patronos,this.situacoes=e.situacoes}}],[{key:"findByIdJogador",value:function(){return fetch("api/ficha/jogador",{method:"GET",headers:p.getMyHeaders(),credentials:"include"}).then((function(e){return e.json()})).then((function(e){return e}))}}]),e}(),Q=a(91),V=function(e){function t(e){var a;return Object(s.a)(this,t),(a=Object(l.a)(this,Object(o.a)(t).call(this,e))).state={ficha:a.props.ficha},a}return Object(d.a)(t,e),Object(r.a)(t,[{key:"componentDidUpdate",value:function(e,t,a){JSON.stringify(e.ficha)!==JSON.stringify(this.props.ficha)&&this.setState({ficha:this.props.ficha})}},{key:"render",value:function(){var e=this.state.ficha;return n.createElement(L.a,{hover:!0,size:"sm"},n.createElement("thead",null,n.createElement("tr",null,n.createElement("th",null,"Atributos"),n.createElement("th",null,"R"),n.createElement("th",null,"DS"),n.createElement("th",null,"B.Gerais"),n.createElement("th",null,"TT"))),n.createElement("tbody",null,n.createElement("tr",null,n.createElement("th",null,"FOR"),n.createElement("td",null,e.raca.racaForca),n.createElement("td",null,e.distForca),n.createElement("td",null,n.createElement(Q.a,{as:"input",type:"number",size:"sm",plaintext:!0,value:"0",readOnly:!0})),n.createElement("td",null,e.distForca+(void 0!==e.raca.racaForca?e.raca.racaForca:0))),n.createElement("tr",null,n.createElement("th",null,"CON"),n.createElement("td",null,e.raca.racaConstituicao),n.createElement("td",null,e.distConstituicao),n.createElement("td",null,n.createElement(g.a.Control,{as:"input",type:"number",size:"sm",plaintext:!0,value:"0",readOnly:!0})),n.createElement("td",null,e.distConstituicao+(void 0!==e.raca.racaConstituicao?e.raca.racaConstituicao:0))),n.createElement("tr",null,n.createElement("th",null,"AGI"),n.createElement("td",null,e.raca.racaAgilidade),n.createElement("td",null,e.distAgilidade),n.createElement("td",null,n.createElement(Q.a,{as:"input",type:"number",size:"sm",plaintext:!0,value:"0",readOnly:!0})),n.createElement("td",null,e.distForca+(void 0!==e.raca.racaForca?e.raca.racaForca:0))),n.createElement("tr",null,n.createElement("th",null,"DES"),n.createElement("td",null,e.raca.racaDestreza),n.createElement("td",null,e.distDestreza),n.createElement("td",null,n.createElement(Q.a,{as:"input",type:"number",size:"sm",plaintext:!0,value:"0",readOnly:!0})),n.createElement("td",null,e.distAgilidade+(void 0!==e.raca.racaAgilidade?e.raca.racaAgilidade:0))),n.createElement("tr",null,n.createElement("th",null,"INT"),n.createElement("td",null,e.raca.racaInteligencia),n.createElement("td",null,e.distInteligencia),n.createElement("td",null,n.createElement(Q.a,{as:"input",type:"number",size:"sm",plaintext:!0,value:"0",readOnly:!0})),n.createElement("td",null,e.distInteligencia+(void 0!==e.raca.racaInteligencia?e.raca.racaInteligencia:0))),n.createElement("tr",null,n.createElement("th",null,"SAB"),n.createElement("td",null,e.raca.racaSabedoria),n.createElement("td",null,e.distSabedoria),n.createElement("td",null,n.createElement(Q.a,{as:"input",type:"number",size:"sm",plaintext:!0,value:"0",readOnly:!0})),n.createElement("td",null,e.distSabedoria+(void 0!==e.raca.racaSabedoria?e.raca.racaSabedoria:0))),n.createElement("tr",null,n.createElement("th",null,"CAR"),n.createElement("td",null,e.raca.racaCarisma),n.createElement("td",null,e.distCarisma),n.createElement("td",null,n.createElement(Q.a,{as:"input",type:"number",size:"sm",plaintext:!0,value:"0",readOnly:!0})),n.createElement("td",null,e.distCarisma+(void 0!==e.raca.racaCarisma?e.raca.racaCarisma:0)))))}}]),t}(n.Component),$=a(92),X=a(162),Y=a(93),Z=a(168),ee=function(e){function t(e){var a;return Object(s.a)(this,t),(a=Object(l.a)(this,Object(o.a)(t).call(this,e))).state={ficha:a.props.ficha,readonly:!0},a}return Object(d.a)(t,e),Object(r.a)(t,[{key:"componentDidUpdate",value:function(e,t,a){e.ficha.idade!==this.props.ficha.idade&&this.setState({ficha:this.props.ficha})}},{key:"render",value:function(){var e=this;return n.createElement($.a,{as:X.a},n.createElement(Y.a,{lg:"auto"},n.createElement(Z.a.Label,{column:!1},"Idade")),n.createElement(Y.a,null,n.createElement(Q.a,{as:"input",type:"number",plaintext:!0,readOnly:this.state.readonly,value:this.state.ficha.idade.toString(),onDoubleClick:function(){return e.setState({readonly:!1})},onBlur:function(){return e.setState({readonly:!0})},onChange:function(t){var a=t.target.value;e.setState((function(e){return e.ficha.idade=Number(a),{ficha:e.ficha}}))}})))}}]),t}(n.Component),te=a(46),ae=a.n(te),ne=function(e){function t(e){var a;return Object(s.a)(this,t),(a=Object(l.a)(this,Object(o.a)(t).call(this,e))).state={ficha:a.props.ficha,readonly:!0},a}return Object(d.a)(t,e),Object(r.a)(t,[{key:"componentDidUpdate",value:function(e,t,a){e.ficha.nivelPersonagem!==this.props.ficha.nivelPersonagem&&this.setState({ficha:this.props.ficha})}},{key:"render",value:function(){return i.a.createElement($.a,{as:X.a},i.a.createElement(Z.a.Label,{column:!0,sm:2},"Nivel"),i.a.createElement(Y.a,null,i.a.createElement(ae.a,{as:"input",type:"number",value:this.state.ficha.nivelPersonagem.toString(),readOnly:this.state.readonly,plaintext:this.state.readonly})))}}]),t}(i.a.Component),ie=function(e){function t(e){var a;return Object(s.a)(this,t),(a=Object(l.a)(this,Object(o.a)(t).call(this,e))).state={ficha:a.props.ficha,readonly:!0},a}return Object(d.a)(t,e),Object(r.a)(t,[{key:"componentDidUpdate",value:function(e,t,a){e.ficha.expPersonagem!==this.props.ficha.expPersonagem&&this.setState({ficha:this.props.ficha})}},{key:"render",value:function(){return i.a.createElement($.a,{as:X.a},i.a.createElement(Z.a.Label,{column:!0,sm:2},"Exp"),i.a.createElement(Y.a,null,i.a.createElement(ae.a,{as:"input",type:"number",value:this.state.ficha.expPersonagem.toString(),readOnly:this.state.readonly,plaintext:this.state.readonly})))}}]),t}(i.a.Component),ce=a(163),se=a(164),re=a(165),le=a(167),oe=a(96),de=a(166),he=function(e){function t(e){var a;Object(s.a)(this,t);var n=(a=Object(l.a)(this,Object(o.a)(t).call(this,e))).props.descendenciaSelecionada?a.props.descendenciaSelecionada:R.sistema.descendencias[0];return a.state={show:!1,descendenciaSelecionada:n,value:"0",isInvalid:!1},a}return Object(d.a)(t,e),Object(r.a)(t,[{key:"tabDesc",value:function(){return i.a.createElement(ce.a,{eventKey:"descDescendencia",title:"Descri\xe7\xe3o"},i.a.createElement(X.a,null,i.a.createElement(Y.a,null,this.state.descendenciaSelecionada.descDescendencia)))}},{key:"tabHabilidade",value:function(){return this.state.descendenciaSelecionada.habilidades.length>0?i.a.createElement(ce.a,{eventKey:"habilidades",title:"habilidades"},i.a.createElement(Y.a,null,this.state.descendenciaSelecionada.habilidades.map((function(e,t){return i.a.createElement(X.a,{key:t},i.a.createElement(Y.a,null,e.nomeHabilidade),i.a.createElement(Y.a,null,e.descHabilidade))})))):i.a.createElement(ce.a,{eventKey:"habilidades",title:"habilidades",disabled:!0},"empty")}},{key:"tabHabitos",value:function(){return this.state.descendenciaSelecionada.habitos.length>0?i.a.createElement(ce.a,{eventKey:"habitos",title:"habitos"},i.a.createElement(se.a,null,i.a.createElement("thead",null,i.a.createElement("tr",null,i.a.createElement("th",null,"Nome"),i.a.createElement("th",null,"Quantidade"))),i.a.createElement("tbody",null,this.state.descendenciaSelecionada.habitos.map((function(e,t){return i.a.createElement("tr",{key:t},i.a.createElement("td",null,e.nomeHabito),i.a.createElement("td",null,e.qtdFichaHabito))}))))):i.a.createElement(ce.a,{eventKey:"habitos",title:"habitos",disabled:!0},"empty")}},{key:"render",value:function(){var e=this;return i.a.createElement("div",null,i.a.createElement(re.a,{size:"sm",variant:"outline-info",onClick:function(){return e.setState({show:!0})}},this.props.buttonIcon),i.a.createElement(le.a,{show:this.state.show,onHide:function(){return e.setState({show:!1})}},i.a.createElement(le.a.Header,{closeButton:!0},i.a.createElement(Q.a,{value:this.state.value,as:"select",plaintext:!1,isInvalid:this.state.isInvalid,onChange:function(t){var a=t.target.value;e.setState((function(t){var n=e.props.descendencias.find((function(e){return e.idDescendencia.toString()===a}));return{descendenciaSelecionada:n=n||t.descendenciaSelecionada,value:n.idDescendencia.toString(),isInvalid:!1}}))}},this.props.descendencias.map((function(e,t){return i.a.createElement("option",{value:e.idDescendencia,key:t},e.nomeDescendencia)})))),i.a.createElement(oe.a,null,i.a.createElement(de.a,{defaultActiveKey:"descDescendencia",id:"tab-escolha-descendencia"},this.tabDesc(),this.tabHabilidade(),this.tabHabitos()),i.a.createElement(X.a,null,i.a.createElement(re.a,{onClick:function(){e.props.adicionaDescendencia(e.state.descendenciaSelecionada,e.props.descendenciaSelecionada)?e.setState({show:!1}):e.setState({isInvalid:!0})}},this.props.buttonText)))))}}]),t}(i.a.Component),ue=(a(155),function(e){function t(e){var a;return Object(s.a)(this,t),(a=Object(l.a)(this,Object(o.a)(t).call(this,e))).state={ficha:a.props.ficha,sistema:R.sistema,modalDescShow:[],modalCriacShow:!1},a}return Object(d.a)(t,e),Object(r.a)(t,[{key:"componentDidMount",value:function(){this.setState((function(e){return e.modalDescShow.fill(!1,0,e.ficha.descendencias.length),{modalDescShow:e.modalDescShow}}))}},{key:"componentDidUpdate",value:function(e,t,a){JSON.stringify(e.ficha.descendencias)!==JSON.stringify(this.props.ficha.descendencias)&&this.setState({ficha:this.props.ficha})}},{key:"trocaDescendencia",value:function(e,t){var a=this.state.ficha.descendencias.findIndex((function(e){return t.idDescendencia===e.idDescendencia}));return!this.state.ficha.descendencias.find((function(t){return t.idDescendencia===e.idDescendencia}))&&(this.setState((function(t){return t.ficha.descendencias[a]=e,{ficha:t.ficha}})),!0)}},{key:"adicionaDescendencia",value:function(e){return!this.state.ficha.descendencias.find((function(t){return t.idDescendencia===e.idDescendencia}))&&(this.setState((function(t){return t.ficha.descendencias.push(e),{ficha:t.ficha}})),!0)}},{key:"render",value:function(){var e=this;return i.a.createElement($.a,null,i.a.createElement(X.a,null,i.a.createElement(Y.a,{lg:10},i.a.createElement(Z.a.Label,{column:!1},"Descendencias")),i.a.createElement(Y.a,{lg:"auto",md:"auto"},i.a.createElement(he,{buttonIcon:"+",buttonText:"Add",descendencias:R.sistema.descendencias,adicionaDescendencia:this.adicionaDescendencia.bind(this)}))),this.state.ficha.descendencias.map((function(t,a){return i.a.createElement(X.a,{key:a},i.a.createElement(Y.a,{lg:10},i.a.createElement("p",null,t.nomeDescendencia)),i.a.createElement(Y.a,{lg:"auto",md:"auto"},i.a.createElement(he,{buttonIcon:"#",buttonText:"Save",descendencias:R.sistema.descendencias,adicionaDescendencia:e.trocaDescendencia.bind(e),descendenciaSelecionada:t})))})))}}]),t}(i.a.Component)),me=function(e){function t(e){var a;return Object(s.a)(this,t),(a=Object(l.a)(this,Object(o.a)(t).call(this,e))).state={ficha:new q(Number(D.a.parse(window.location.href.split("?")[1]).idFicha)),sistema:R.sistema},a}return Object(d.a)(t,e),Object(r.a)(t,[{key:"componentDidMount",value:function(){var e=this;fetch("api/ficha/id/"+this.state.ficha.idFicha,{method:"GET",headers:p.getMyHeaders()}).then((function(e){return e.json()})).then((function(t){e.setState({ficha:t})}))}},{key:"render",value:function(){var e=this.state.ficha;return n.createElement(k.a,null,n.createElement(F.a,null,n.createElement(x.a,{md:"auto"},n.createElement(T,null)),n.createElement(x.a,null,n.createElement(k.a,null,n.createElement(F.a,null,n.createElement("legend",null,"Personagem")),n.createElement(F.a,null,n.createElement(x.a,{md:3},n.createElement(B,{ficha:e}),n.createElement(ee,{ficha:e})),n.createElement(x.a,null,n.createElement(F.a,null,n.createElement(ne,{ficha:e})),n.createElement(F.a,null,n.createElement(ie,{ficha:e}))),n.createElement(x.a,{md:3},n.createElement(U,{ficha:e})),n.createElement(x.a,null,n.createElement(G,{ficha:e}))),n.createElement(F.a,null,n.createElement(x.a,null,n.createElement(ue,{ficha:e})),n.createElement(x.a,null,"espa\xe7o vazio")),n.createElement(F.a,null,n.createElement(x.a,null,n.createElement(V,{ficha:e})),n.createElement(x.a,null,n.createElement(W,{ficha:e})))))))}}]),t}(n.Component),fe=(a(156),a(69)),pe=a.n(fe),be=function(e){function t(e){var a;return Object(s.a)(this,t),(a=Object(l.a)(this,Object(o.a)(t).call(this,e))).state={resumoFichas:[],sistema:R.sistema},a}return Object(d.a)(t,e),Object(r.a)(t,[{key:"componentDidUpdate",value:function(e,t,a){console.log(this.state.resumoFichas)}},{key:"componentDidMount",value:function(){var e=this;this.fetchResumoFichas(),q.findByIdJogador().then((function(t){e.setState({resumoFichas:t})}))}},{key:"handleAction",value:function(e){window.location.hash="#/ficha?idFicha="+e}},{key:"fetchResumoFichas",value:function(){var e=this;return this.state.resumoFichas.map((function(t){return n.createElement(j.a,{variant:"outline-dark",onClick:e.handleAction.bind(e,t.idFicha)},n.createElement(F.a,null,n.createElement(x.a,{className:"corpo"},n.createElement("label",null,"Nome: "),n.createElement("h3",null,t.nomePersonagem)),n.createElement(x.a,null,n.createElement(pe.a,null))))}))}},{key:"render",value:function(){var e=this;return n.createElement(k.a,null,this.state.resumoFichas.map((function(t){return n.createElement(j.a,{className:"ficha-sel",variant:"outline-dark",onClick:e.handleAction.bind(e,t.idFicha)},n.createElement(F.a,null,n.createElement(x.a,{className:"corpo"},n.createElement("label",null,"Nome: "),n.createElement("h3",null,t.nomePersonagem)),n.createElement(x.a,null,n.createElement(pe.a,{src:t.img,alt:"fail to load"}))))})))}}]),t}(n.Component),Ee=function(e){function t(){return Object(s.a)(this,t),Object(l.a)(this,Object(o.a)(t).apply(this,arguments))}return Object(d.a)(t,e),Object(r.a)(t,[{key:"render",value:function(){return i.a.createElement("div",null,i.a.createElement(h.a,null,i.a.createElement(u.c,null,i.a.createElement(u.a,{path:"/",exact:!0,component:C}),i.a.createElement(u.a,{path:"/escolhe_ficha",component:be}),i.a.createElement(u.a,{path:"/ficha",component:me}))))}}]),t}(i.a.Component),ve=Boolean("localhost"===window.location.hostname||"[::1]"===window.location.hostname||window.location.hostname.match(/^127(?:\.(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)){3}$/));function ye(e,t){navigator.serviceWorker.register(e).then((function(e){e.onupdatefound=function(){var a=e.installing;null!=a&&(a.onstatechange=function(){"installed"===a.state&&(navigator.serviceWorker.controller?(console.log("New content is available and will be used when all tabs for this page are closed. See https://bit.ly/CRA-PWA."),t&&t.onUpdate&&t.onUpdate(e)):(console.log("Content is cached for offline use."),t&&t.onSuccess&&t.onSuccess(e)))})}})).catch((function(e){console.error("Error during service worker registration:",e)}))}a(158);c.render(n.createElement(Ee,null),document.getElementById("root")),function(e){if("serviceWorker"in navigator){if(new URL("",window.location.href).origin!==window.location.origin)return;window.addEventListener("load",(function(){var t="".concat("","/service-worker.js");ve?(!function(e,t){fetch(e).then((function(a){var n=a.headers.get("content-type");404===a.status||null!=n&&-1===n.indexOf("javascript")?navigator.serviceWorker.ready.then((function(e){e.unregister().then((function(){window.location.reload()}))})):ye(e,t)})).catch((function(){console.log("No internet connection found. App is running in offline mode.")}))}(t,e),navigator.serviceWorker.ready.then((function(){console.log("This web app is being served cache-first by a service worker. To learn more, visit https://bit.ly/CRA-PWA")}))):ye(t,e)}))}}()},99:function(e,t,a){e.exports=a(159)}},[[99,1,2]]]);
//# sourceMappingURL=main.4bad53de.chunk.js.map