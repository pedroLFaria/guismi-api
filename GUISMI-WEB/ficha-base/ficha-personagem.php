<!DOCTYPE html>
<html lang="en">
<head>
    <?php include "php\config.php";
          include "php/function.php";
          
          session_start(); 
          $_SESSION["idFichaAtual"] = @$_REQUEST['idFicha'];
    ?>
	<script src="js/ficha-personagem.js"></script>
    <style>
        body {
            font-family: "Lato", sans-serif;
        }

        .sidenav {
            height: 100%;
            width: 160px;
            position: fixed;
            z-index: 1;
            top: 0;
            left: 0;
            background-color: #111;
            overflow-x: hidden;
            padding-top: 20px;
        }

            .sidenav a {
                padding: 6px 8px 6px 16px;
                text-decoration: none;
                font-size: 25px;
                color: #818181;
                display: block;
            }

                .sidenav a:hover {
                    color: #f1f1f1;
                }


        .main {
            margin-left: 160px; /* Same as the width of the sidenav */
            font-size: 28px; /* Increased text to enable scrolling */
            padding: 0px 10px;
        }

        fieldset.scheduler-border {
            border: 1px groove #ddd;
            padding: 0 1.4em 1.4em 1.4em;
            margin: 0 0 1.5em 0 !important;
            -webkit-box-shadow: 0px 0px 0px 0px #000;
            box-shadow: 0px 0px 0px 0px #000;
        }

        legend.scheduler-border {
            font-size: 1.2em;
            font-weight: bold;
            text-align: left;
            width: auto;
            padding: 0 10px;
            border-bottom: none;
        }

        input[type="number"] {
            -webkit-appearance: textfield;
            -moz-appearance: textfield;
            appearance: textfield;
        }

        input[type=number]::-webkit-inner-spin-button,
        input[type=number]::-webkit-outer-spin-button {
            -webkit-appearance: none;
        }


        input[type="number"] {
            -webkit-appearance: textfield;
            -moz-appearance: textfield;
            appearance: textfield;
        }

        input[type=number]::-webkit-inner-spin-button,
        input[type=number]::-webkit-outer-spin-button {
            -webkit-appearance: none;
        }

        .number-input {
            border: 3px solid #ddd;
            display: inline-flex;
        }

            .number-input,
            .number-input * {
                box-sizing: border-box;
            }

                .number-input button {
                    outline: none;
                    -webkit-appearance: none;
                    background-color: transparent;
                    border: none;
                    align-items: center;
                    justify-content: center;
                    width: 40px;
                    height: 40px;
                    cursor: pointer;
                    margin: 0;
                    position: relative;
                }

                    .number-input button:before,
                    .number-input button:after {
                        display: inline-block;
                        position: absolute;
                        content: '';
                        width: 1rem;
                        height: 2px;
                        background-color: #212121;
                        transform: translate(-50%, -50%);
                    }

                    .number-input button.plus:after {
                        transform: translate(-50%, -50%) rotate(90deg);
                    }

                .number-input input[type=number] {
                    font-family: sans-serif;
                    max-width: 5rem;
                    padding: .5rem;
                    border: solid #ddd;
                    border-width: 0 2px;
                    font-size: 2rem;
                    height: 3rem;
                    font-weight: bold;
                    text-align: center;
                }
    </style>
    <title>Bootstrap Example</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.9/angular.min.js"></script>
</head>
<body onload='inicializa()'>
    <div ng-app="viewDoSiteView" ng-controller="viewDoSiteController">
        <div class="container-fluid">
            <div class="row">
                <aside class="col-2 px-0 fixed-top" id="left" style="height: 100%; background-color: lavender">
                    <div class="list-group w-100">
                        <a href="#" class="list-group-item active">Putaria</a>
                        <a href="#" class="list-group-item">Sexo Anal</a>
                        <a href="#" class="list-group-item">Vai se fuder doca</a>
                        <a href="#" class="list-group-item">pq eu to fazendo isso?</a>
                        <h3 class="list-group-item">Conteudo que o gabriel ainda vai decidir</h3>
                        <a href="#" class="list-group-item active">jojo pt 5</a>
                        <a href="#" class="list-group-item">é A segunda pior parte</a>
                        <a href="#" class="list-group-item">So perdendo pra parte 6</a>
                        <a href="#" class="list-group-item">que eu nem vou assistir</a>
                    </div>
                </aside>
                <main class="col-10 invisible">
                    <!--hidden spacer-->
                </main>
                <main class="col offset-2 h-100">
                    <fieldset class="scheduler-border form-group row">
                        <legend class="scheduler-border">Personagem </legend>
                        <div class="row">
                            <div class="row col-md-12">
                                <div class="col-md-2 inline">
                                    <span> Nome </span>
                                    <label for="nome_pers_input" ondblclick="modalTextBox(this)" id="nome_pers"> </label>
                                    <input type="text" class="c form-control " placeholder="" id="nome_pers_input" />
                                </div>
                                <div class="col-md-2">
                                    <span> Raça </span>
                                    <label for="raca_pers_input" ondblclick="modalTextBox(this)" id="raca_pers"></label>
                                    <select id="raca_pers_input" class="form-control" onchange='onChangeRaca(this.value)'>
                                    </select>
                                </div>
                                <div class="col-md-2">
                                    <span> Caminho </span>
                                    <label for="caminhos_pers_input" id="caminhos_pers" ondblclick="modalTextBox(this)"></label>
                                    <select id="caminhos_pers_input" class="form-control" onchange='onChangeCaminho(this.value)'>
                                    </select>
                                </div>
                                <div class="col-md-2">
                                    <span> Idiomas </span>
                                    <label for="idiomas_pers_input" id="idiomas_pers" ondblclick="modalTextBox(this)"></label>
                                    <select id='idiomas_pers_input' class="form-control" placeholder="">
                                    </select>
                                </div>
                                <div class="col-md-2"></div>
                                <div class="col-md-2"></div>
                                <br>
                            </div>
                            <div class="row col-md-12">
                                <div class="col-md-4 " style="text-align: center;">
                                    <table>
                                        <tr>
                                            <td>
                                                Sanidade
                                            </td>
                                        </tr>
                                        <tr>
                                            <td>
                                                <div class="number-input">
                                                    <button ondblclick="modalTextBox(this)" onclick="this.parentNode.querySelector('input[type=number]').stepDown()"></button>
                                                    <input id="sanidade_pers_input" class="quantity" min="-4" max="0" name="quantity" value="0" step="1" type="number">
                                                    <button ondblclick="modalTextBox(this)" onclick="this.parentNode.querySelector('input[type=number]').stepUp()" class="plus"></button>
                                                </div>
                                            </td>
                                        </tr>
                                    </table>
                                </div>
                                <div class="col-md-2" style="text-align: center;">
                                    <table>
                                        <tr>
                                            <td>Nivel</td>
                                        </tr>
                                        <tr>
                                            <td>
                                                <div class="number-input">
                                                    <button ondblclick="modalTextBox(this)" onclick="this.parentNode.querySelector('input[type=number]').stepDown()"></button>
                                                    <input id="nivel_pers_input" class="quantity" min="0" max="40" name="quantity" value="0" step="1" type="number">
                                                    <button ondblclick="modalTextBox(this)" onclick="this.parentNode.querySelector('input[type=number]').stepUp()" class="plus"></button>
                                                </div>                                                
                                            </td>
                                        </tr>
                                    </table>
                                </div>
                                <div class="col-md-2" style="text-align: center;">
                                    <table>
                                        <tr>
                                            <td>Experiência</td>
                                        </tr>
                                        <tr>
                                            <td>
                                                <div class="number-input">
                                                    <button ondblclick="modalTextBox(this)" onclick="this.parentNode.querySelector('input[type=number]').stepDown()"></button>
                                                    <input id="exp_pers_input" class="quantity" min="0" max="40" name="quantity" value="0" step="1" type="number">
                                                    <button ondblclick="modalTextBox(this)" onclick="this.parentNode.querySelector('input[type=number]').stepUp()" class="plus"></button>
                                                </div>                                                
                                            </td>
                                        </tr>
                                    </table>
                                </div>
                            </div>
                            <fieldset class="scheduler-border form-group row">
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
                                        <tr>
                                            <td></td>
                                            <td></td>
                                            <td></td>
                                            <td></td>
                                        </tr>
                                    </tbody>
                                </table>
                            </fieldset>
                        </div>
                    </fieldset>
                    <table>
                        <!-- quadro de combate -->
                        <caption>Quadro</caption>
                        <tbody>
                            <tr>
                                <th>Sangue</th>
                                <td id='sangue_base'>0</td>
                                <td><input type="number" id='sangue_perdido' onkeyup='calculaQuadro()' onchange='calculaQuadro()' /></td>
                                <td id='sangue_total'>0</td>
                            </tr>
                            <tr>
                                <th>Vigor</th>
                                <td id='vigor_base'>0</td>
                                <td><input type="number" id='vigor_perdido' onkeyup='calculaQuadro()' onchange='calculaQuadro()' /></td>
                                <td id='vigor_total'>0</td>
                            </tr>
                            <tr>
                                <th>Mana</th>
                                <td id='mana_base'>0</td>
                                <td><input type="number" id='mana_perdido' onkeyup='calculaQuadro()' onchange='calculaQuadro()' /></td>
                                <td id='mana_total'>0</td>
                            </tr>
                        </tbody>
                        <tbody>
                            <tr>
                                <th>Regen. Sangue</th>
                                <td id='regen_sangue_base'>0</td>
                                <td><input type="number" id='regen_sangue_buff' onkeyup='calculaQuadro()' onchange='calculaQuadro()' /></td>
                                <td id='regen_sange_final'>0</td>
                            </tr>
                            <tr>
                                <th>Regen. Vigor</th>
                                <td id='regen_vigor_base'>0</td>
                                <td><input type="number" id='regen_vigor_buff' onkeyup='calculaQuadro()' onchange='calculaQuadro()' /></td>
                                <td id='regen_vigor_final'>0</td>
                            </tr>
                            <tr>
                                <th>Regen. Mana</th>
                                <td id='regen_mana_base'>0</td>
                                <td><input type="number" id='regen_mana_buff' onkeyup='calculaQuadro()' onchange='calculaQuadro()' /></td>
                                <td id='regen_mana_final'>0</td>
                            </tr>
                        </tbody>
                    </table>
                    <table>
                        <caption>Atributos</caption>
                        <thead>
                            <tr>
                                <th>Atributos</th>
                                <th>R</th>
                                <th>DS</th>
                                <th>B.Gerais</th>
                                <th>TT</th>
                                <th>M5</th>
                                <th>M2</th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <th>FOR</th>
                                <td id="raca_for">0</td>
                                <td><label id="dist_for"></label><input type="number" id="input_dist_for" onkeyup='calculaAtributosFinais()' onchange='calculaAtributosFinais()' onfocusout='setaAtributosInputEmLabel()' /></td>
                                <td><input type='number' id='bg_for' onkeyup='calculaAtributosFinais()' onchange='calculaAtributosFinais()' /></td>
                                <td id="tt_for">0</td>
                                <td id="m5_for">0</td>
                                <td id="m2_for">0</td>
                            </tr>
                            <tr>
                                <th>CON</th>
                                <td id="raca_con">0</td>
                                <td><label id="dist_con"></label><input type="number" id="input_dist_con" onkeyup='calculaAtributosFinais()' onchange='calculaAtributosFinais()' onfocusout='setaAtributosInputEmLabel()' /></td>
                                <td><input type='number' id='bg_con' onkeyup='calculaAtributosFinais()' onchange='calculaAtributosFinais()' /></td>
                                <td id="tt_con">0</td>
                                <td id="m5_con">0</td>
                                <td id="m2_con">0</td>
                            </tr>
                            <tr>
                                <th>AGI</th>
                                <td id="raca_agi">0</td>
                                <td><label id="dist_agi"></label><input type="number" id="input_dist_agi" onkeyup='calculaAtributosFinais()' onchange='calculaAtributosFinais()' onfocusout='setaAtributosInputEmLabel()' /></td>
                                <td><input type='number' id='bg_agi' onkeyup='calculaAtributosFinais()' onchange='calculaAtributosFinais()' /></td>
                                <td id="tt_agi">0</td>
                                <td id="m5_agi">0</td>
                                <td id="m2_agi">0</td>
                            <tr>
                                <th>DES</th>
                                <td id="raca_des">0</td>
                                <td><label id="dist_des"></label><input type="number" id="input_dist_des" onkeyup='calculaAtributosFinais()' onchange='calculaAtributosFinais()' onfocusout='setaAtributosInputEmLabel()' /></td>
                                <td><input type='number' id='bg_des' onkeyup='calculaAtributosFinais()' onchange='calculaAtributosFinais()' /></td>
                                <td id="tt_des">0</td>
                                <td id="m5_des">0</td>
                                <td id="m2_des">0</td>
                            </tr>
                            <tr>
                                <th>INT</th>
                                <td id="raca_int">0</td>
                                <td><label id="dist_int"></label><input type="number" id="input_dist_int" onkeyup='calculaAtributosFinais()' onchange='calculaAtributosFinais()' onfocusout='setaAtributosInputEmLabel()' /></td>
                                <td><input type='number' id='bg_int' onkeyup='calculaAtributosFinais()' onchange='calculaAtributosFinais()' /></td>
                                <td id="tt_int">0</td>
                                <td id="m5_int">0</td>
                                <td id="m2_int">0</td>
                            </tr>
                            <tr>
                                <th>SAB</th>
                                <td id="raca_sab">0</td>
                                <td><label id="dist_sab"></label><input type="number" id="input_dist_sab" onkeyup='calculaAtributosFinais()' onchange='calculaAtributosFinais()' onfocusout='setaAtributosInputEmLabel()' /></td>
                                <td><input type='number' id='bg_sab' onkeyup='calculaAtributosFinais()' onchange='calculaAtributosFinais()' /></td>
                                <td id="tt_sab">0</td>
                                <td id="m5_sab">0</td>
                                <td id="m2_sab">0</td>
                            </tr>
                            <tr>
                                <th>CAR</th>
                                <td id="raca_car">0</td>
                                <td><label id="dist_car"></label><input type="number" id="input_dist_car" onkeyup='calculaAtributosFinais()' onchange='calculaAtributosFinais()' onfocusout='setaAtributosInputEmLabel()' /></td>
                                <td><input type='number' id='bg_car' onkeyup='calculaAtributosFinais()' onchange='calculaAtributosFinais()' /></td>
                                <td id="tt_car">0</td>
                                <td id="m5_car">0</td>
                                <td id="m2_car">0</td>
                            </tr>
                        </tbody>
                    </table>
                    <table name="">
                        <caption>Hábitos</caption>
                        <thead>
                            <tr>
                                <th id="tabela-habitos-compelta-habitos">Hábitos</th>
                                <th>G</th>
                                <th>DT</th>
                                <th>BG</th>
                                <th>TT</th>
                                <th>M10</th>
                                <th>M5</th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <th>XXXX</th>
                                <td>0</td>
                                <td><label>0</label><input type="number" /></td>
                                <td>0</td>
                                <td>0</td>
                                <td>0</td>
                                <td>0</td>
                            </tr>
                        </tbody>
                    </table>
                    <button>+</button>
                    <table>
                        <caption>Especialização</caption>
                        <tbody>
                            <tr>
                                <td>ESP:XXXX</td>
                            </tr>
                        </tbody>
                    </table>
                    <table class="tabela-atributos col-4">
                        <caption>Defesas</caption>
                        <tr>
                            <th>Reflex</th>
                            <td>1</td>
                        </tr>
                        <tr>
                            <th>fortitude</th>
                            <td>1</td>
                        </tr>
                        <tr>
                            <th>Vontade</th>
                            <td>1</td>
                        </tr>
                    </table>
                    <table>
                        <caption>Habilidades</caption>
                        <tr>
                            <th>Nome Habilidade<input type="text" value="Nome Habilidade"></th>
                            <td>
                                AtAc.:
                                <label>FOR</label>
                                <select>
                                    <option>FOR</option>
                                    <option>CON</option>
                                    <option>AGI</option>
                                    <option>DES</option>
                                    <option>INT</option>
                                    <option>SAB</option>
                                    <option>CAR</option>
                                </select>
                                Mod.:<label>0</label>
                                Tipo<span></span><input type="text" />
                            </td>
                            <td>
                                Hábito:<label>XXX</label>
                                <select></select>
                                M10:<label></label>
                                5:<label></label>
                            </td>
                            <td>
                                Gastos:
                                <label></label>
                                <label></label>
                                <label></label>
                            </td>
                            <td>
                                Utilização:
                                <input type="text" />
                                <label></label>
                            </td>
                            <td>
                                <label nome="desc_hab"></label>
                                <textarea>
                                    descrição da Habilidade
                                </textarea>
                            </td>
                            <td>
                                <label></label>
                                <input type="text" nome="pre_req" />
                            </td>
                        </tr>
                    </table>
                </main>
            </div>
        </div>
    </div>
</body>
</html>

