class Habitos extends React.Component {
    render() {
        return (<table className="table">
            <thead className="thead-dark">
            <tr>
                <th>HABITOS</th>
                <th>Quantidade</th>
                <th>Mod5</th>
                <th>Mod10</th>
            </tr>
            </thead>
            <tbody>
            {this.props.habitos.map((habito) =>
                <tr>
                    <td>{habito.nomeHabito}</td>
                    <td>{habito.qtdFichaHabito}</td>
                    <td>{habito.qtdFichaHabito / 5}</td>
                    <td>{habito.qtdFichaHabito / 10}</td>
                </tr>)}
            </tbody>
        </table>)
    }
}

class Caminho extends React.Component {
    iterator = 0;
    constructor(props) {
        super(props);
        this.state = {
            ficha: this.props.ficha,
            sistema: this.props.sistema,
        };
        this.handleChange = this.handleChange.bind(this)
    }

    handleChange(event) {
        if (this.state.ficha.caminhos.every(caminho => caminho.idCaminho !== Number(event.target.value))) {
            this.state.ficha.caminhos[event.target.id].idCaminho = Number(event.target.value);
            this.setState({ficha: this.state.ficha});
            this.render()
            const xhr = new XMLHttpRequest();
            xhr.addEventListener('load', () => {
                console.log("uploaded")
            });
            xhr.open('PUT', 'api/ficha/');
            xhr.setRequestHeader("Content-Type", "application/json;charset=UTF-8");
            xhr.send(JSON.stringify(this.state.ficha));
        }else
            alert("Você já tem este caminho")
    }

    componentDidUpdate(prevProps) {
        console.log("caminho did update: " + JSON.stringify(prevProps.ficha.caminhos))
        if(prevProps.ficha.caminhos.length !== this.props.ficha.caminhos.length){
            this.setState({ficha:this.props.ficha})
        }
        for(let caminho in this.props.ficha.caminhos){
            if(prevProps.ficha.caminhos.every(prevCaminho => prevCaminho.idCaminho !== this.props.ficha.caminhos[caminho].idCaminho))
                this.setState({ficha:this.props.ficha})
        }
    }

    render() {
        this.iterator = 0;
        return (
            this.state.ficha.caminhos.map(caminho =>
                <div>
                    <select value={caminho.idCaminho} id={this.iterator++} className={"form-control"} onChange={this.handleChange}>
                        {this.state.sistema.caminhos.map(caminho =>
                            <option value={caminho.idCaminho}> {caminho.nomeCaminho} </option>)}
                    </select>< br/>
                </div>
            )
        )
    }
}

class Raca extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            ficha: this.props.ficha,
            sistema: this.props.sistema
        };
        this.handleChange = this.handleChange.bind(this);
    }

    handleChange(event) {
        this.state.ficha.idRaca = Number(event.target.value);
        this.setState({ficha:this.state.ficha});
        this.render();
        const xhr = new XMLHttpRequest();
        xhr.addEventListener('load', () => {
        });
        xhr.open('PUT', 'api/ficha/');
        xhr.setRequestHeader("Content-Type", "application/json;charset=UTF-8");
        xhr.send(JSON.stringify(this.state.ficha));
    }

    componentDidUpdate(prevProps){
        if(prevProps.ficha.idRaca !== this.props.ficha.idRaca)
            this.setState({ficha:this.props.ficha})
    }

    render() {
        return (
            <select value={this.state.ficha.idRaca} onChange={this.handleChange} className="form-control">
                {this.state.sistema.racas.map((raca) => <option value={raca.idRaca}>{raca.nomeRaca}</option>)}
            </select>
        )
    }
}

class Nome extends React.Component{
    constructor(props) {
        super(props);
        this.state = {
            ficha: this.props.ficha
        };
        this.handleChange = this.handleChange.bind(this);
        this.putFicha = this.putFicha.bind(this);
    }

    handleChange(event) {
        this.state.ficha.nomePersonagem = event.target.value;
        this.setState({ficha:this.state.ficha});
        this.render();
    }

    putFicha(){
        const xhr = new XMLHttpRequest();
        xhr.addEventListener('load', () => {
        });
        xhr.open('PUT', 'api/ficha/');
        xhr.setRequestHeader("Content-Type", "application/json;charset=UTF-8");
        xhr.send(JSON.stringify(this.state.ficha));
    }

    componentDidUpdate(prevProps){
        if(prevProps.ficha.nomePersonagem !== this.props.ficha.nomePersonagem)
            this.setState({ficha:this.props.ficha})
    }

    render(){
        return (
            <input type="text" value={this.state.ficha.nomePersonagem}  onChange={this.handleChange} onBlur={this.putFicha} className="c form-control"
                   placeholder="" id="nome_pers_input"/>
        )
    }
}

class Ficha extends React.Component {
    constructor(props) {
        super(props);
        this.tick();
        this.state = {
            ficha: {caminhos: [], descendencias: [], habilidades: [], habitos: [], idiomas: [], inventarios: [], patronos: [], raca: {}, situacoes: []},
            sistema: JSON.parse(sessionStorage.getItem("sistema"))
        };

    };

    componentDidMount() {
      //  this.timerID = setInterval(() => this.tick(), 3000);
    };

    tick() {
        fetch("api/ficha/id/" + new URL(window.location.href).searchParams.get("idFicha"), {method: "GET", Header: new Headers})
            .then(status)
            .then(response => response.json())
            .then(data => {
                sessionStorage.setItem("ficha", JSON.stringify(data));
                this.setState({ficha: data})
            })
    }

    render() {
        const ficha = this.state.ficha;
        const sistema = this.state.sistema;
        const habitosConst = this.state.ficha.habitos;
        const caminhosConst = this.state.ficha.caminhos;
        return (
            <fieldset className="scheduler-border form-group row">
                <legend className="scheduler-border">Personagem</legend>
                <div className="row">
                    <div className="row col-md-12">
                        <div className="col-md-2 inline">
                            <span>Nome</span>
                            <Nome
                                ficha={ficha}
                                sistema={sistema}
                                />
                        </div>
                        <div className="col-md-2">
                            <span>Raça</span>
                            <Raca
                                ficha={ficha}
                                sistema={sistema}/>
                        </div>
                        <div className="col-md-2">
                            <span>Caminho</span>
                            <Caminho
                                ficha={ficha}
                                sistema={sistema}
                                caminhos = {caminhosConst}
                            />
                        </div>
                    </div>
                    <Habitos
                        habitos={habitosConst}
                    />
                </div>
            </fieldset>
        )
    }
}
ReactDOM.render(
    <Ficha
        ficha = {JSON.parse(sessionStorage.getItem("ficha"))}
    />,
    document.getElementById('telaPersonagem'));
