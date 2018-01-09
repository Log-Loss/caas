package com.logloss.hinetconfigserver;

import com.logloss.hinetconfigserver.Convolution.ConvConfig;
import com.logloss.hinetconfigserver.Convolution.ConvModel;
import com.logloss.hinetconfigserver.Dense.DenseConfig;
import com.logloss.hinetconfigserver.Dense.DenseModel;
import com.logloss.hinetconfigserver.Recurrent.RnnConfig;
import com.logloss.hinetconfigserver.Recurrent.RnnModel;
import org.deeplearning4j.nn.conf.MultiLayerConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ModelService {

    @Autowired
    private ModelRepository modelRepository;

    public ModelConfig buildDenseModel(DenseConfig config) {
        MultiLayerConfiguration configuration = new DenseModel(config).getConfig();
        ModelConfig modelConfig = new ModelConfig(config.userId, configuration.toJson());
        modelRepository.insert(modelConfig);

        return modelConfig;
    }

    public ModelConfig buildConvModel(ConvConfig config) {
        MultiLayerConfiguration configuration = new ConvModel(config).getConfig();
        ModelConfig modelConfig = new ModelConfig(config.userId, configuration.toJson());
        modelRepository.insert(modelConfig);

        return modelConfig;
    }

    public ModelConfig buildRnnModel(RnnConfig config) {
        MultiLayerConfiguration configuration = new RnnModel(config).getConfig();
        ModelConfig modelConfig = new ModelConfig(config.userId, configuration.toJson());
        modelRepository.insert(modelConfig);

        return modelConfig;
    }

    public ModelConfig getModelById(String id) {
        return modelRepository.getModelConfigByModelId(id);
    }

    public List<ModelConfig> getModelsByUserId(String id) {
        return modelRepository.getModelConfigsByUserId(id);
    }
}
