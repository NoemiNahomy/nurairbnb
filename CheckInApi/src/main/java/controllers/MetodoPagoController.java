package controllers;

import an.awesome.pipelinr.Pipeline;
import dtos.MetodoPagoDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import use.cases.command.metodopago.create.CreateMetodoPagoCommand;
import use.cases.command.metodopago.get.GetMetodoPagoQuery;
import use.cases.command.metodopago.list.GetListMetodoPagoQuery;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
public class MetodoPagoController {

    Logger logger = LoggerFactory.getLogger(MetodoPagoController.class);
    final Pipeline pipeline;

    public MetodoPagoController(Pipeline pipeline) {
        this.pipeline = pipeline;
    }

    @GetMapping("/metodopago/{id}")
    public List<MetodoPagoDto> getMetodoPago(@PathVariable String id) {
        GetMetodoPagoQuery query = new GetMetodoPagoQuery(id);
        return query.execute(pipeline);
    }

    @GetMapping("/metodopago-list")
    public List<MetodoPagoDto> getListAllTipoPropiedades() {
        GetListMetodoPagoQuery query = new GetListMetodoPagoQuery();
        return query.execute(pipeline);
    }

    @PostMapping("/metodopago/create")
    public MetodoPagoDto createTipo(@RequestBody MetodoPagoDto metodoDto) {

        CreateMetodoPagoCommand createMetodoCommand = new CreateMetodoPagoCommand(
                metodoDto
        );
        return createMetodoCommand.execute(pipeline);
    }
}
