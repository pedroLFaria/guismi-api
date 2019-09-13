class ResumoFicha extends React.Component {
  constructor(){
    super();
    this.state = {
      resumoFichas : []
    }
  }

  componentDidMount() {
      this.getSistema();
      this.fetchResumoFichas();
  }
  fetchResumoFichas(){
    fetch("api/ficha/jogador", { method:"GET", Header : new Headers })
        .then(status)
        .then(response => response.json())
        .then(data=>{
          let resumoFichas = data.map((ficha) =>{
            return(
                <div>
                  <form action="ficha-personagem.html" method="GET">
                    <button className='ficha-sel' name='idFicha' value={ficha.idFicha}>
                      <div className="corpo">
                        <label className='botao-texto' type="submit" id={ficha.idFicha}>
                          <label>Nome:
                          </label>
                          <h3>{ficha.nomePersonagem}</h3>
                        </label>
                        <img src={ficha.img}/>
                      </div>
                    </button>
                  </form><br />
                </div>
            )
          });
          this.setState({resumoFichas:resumoFichas})
        })
  }
  getSistema(){
    const xhr = new XMLHttpRequest();
    xhr.addEventListener('load', ()=>{sessionStorage.setItem("sistema", xhr.responseText)});
    xhr.open('GET','api/sistema');
    xhr.send();
  }

  render () {
    return(
      <div>
        {this.state.resumoFichas}
      </div>
    )
  }
}
ReactDOM.render(<ResumoFicha />,document.getElementById('root'));
