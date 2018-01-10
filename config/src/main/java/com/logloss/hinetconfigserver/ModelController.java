package com.logloss.hinetconfigserver;

import com.logloss.hinetconfigserver.Convolution.ConvConfig;
import com.logloss.hinetconfigserver.Dense.DenseConfig;
import com.logloss.hinetconfigserver.Recurrent.RnnConfig;
import com.logloss.hinetconfigserver.Utils.ReturnConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class ModelController {

    @Autowired
    private ModelService modelService;

    /* dense neural network */
    @RequestMapping(value = "/dense", method = RequestMethod.POST)
    public String buildDenseModel(@RequestBody DenseConfig config) {
        ModelConfig conf = modelService.buildDenseModel(config);
//        System.out.println(conf);
//        //for test
//        MultiLayerNetwork model = new MultiLayerNetwork(conf);
//        DataSetIterator iterator = new IrisDataSetIterator(32, 100);
//        model.fit(iterator);
//        Evaluation eval = model.evaluate(iterator);
//        System.out.println(eval);
        return conf.getConfiguration();
    }

    /* convolutional neural network */
    @RequestMapping(value = "/conv", method = RequestMethod.POST)
    public String buildConvModel(@RequestBody ConvConfig config) throws Exception {
        ModelConfig conf = modelService.buildConvModel(config);
//        System.out.println(conf);
//        //for test
//        MultiLayerNetwork model = new MultiLayerNetwork(conf);
//        DataSetIterator iterator = new MnistDataSetIterator(32, 100);
//        model.fit(iterator);
//        Evaluation eval = model.evaluate(iterator);
//        System.out.println(eval);
        return conf.getConfiguration();
    }

    /* recurrent neural network */
    @RequestMapping(value = "/rnn", method = RequestMethod.POST)
    public String buildRnnModel(@RequestBody RnnConfig config) throws Exception {
        ModelConfig conf = modelService.buildRnnModel(config);
//        System.out.println(conf);
        return conf.getConfiguration();
    }

    @RequestMapping("/model")
    public ModelConfig getModelById(@RequestParam("modelId") String id) {
        return modelService.getModelById(id);
    }

    @RequestMapping("/user")
    public List<ModelConfig> getModesByUserId(@RequestParam("userId") String id) {
        return modelService.getModelsByUserId(id);
    }


}
