package caas.poc.service;

import caas.poc.entity.Job;
import caas.poc.repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JobService {
    @Autowired
    private JobRepository jobRepository;

    public Job create(Integer modelId) {
        return null;
    }

    public void removeAll() {
        jobRepository.deleteAll();
    }

}
