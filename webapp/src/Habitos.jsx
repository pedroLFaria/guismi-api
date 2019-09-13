class Habitos extends React.Components {
    constructor(props){
        super(props);
        this.state.habitos = props.habitos;
    }

    retornaHabitos(){
        this.state.habitos
    }
    
    render(){
        return (<fieldset class="scheduler-border form-group row">
                                    <legend class="scheduler-border">Descendências</legend>
                                    <table class="table">
                                        <thead class="thead-dark">
                                            <tr>
                                                <th>HABITOS</th>
                                                <th>Dividido Por 2</th>
                                                <th>Dividido Por 5</th>
                                                <th>Dividido Por 10</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                        </tbody>
                                    </table>
                                </fieldset>
                    )
    }
    
}

export default Habitos