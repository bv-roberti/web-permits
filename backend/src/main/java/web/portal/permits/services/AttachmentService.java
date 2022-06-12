package web.portal.permits.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.portal.permits.entities.Attachment;
import web.portal.permits.errors.ResourceNotFoundProblem;
import web.portal.permits.repository.AttachmentRepository;

import java.util.List;

@Service
public class AttachmentService {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private AttachmentRepository attachmentRepository;

    public List<Attachment> findAll(){
        return attachmentRepository.findAll();
    }

    public Attachment findById(Long Id){
        Attachment attachment = attachmentRepository.findById(Id).orElseThrow(() -> new ResourceNotFoundProblem(Id));
        return attachment;
    }

    public Attachment save(Attachment attachment){
        return attachmentRepository.save(attachment);
    }

    public Attachment update(Long Id, Attachment attachment){
        Attachment _Attachment = attachmentRepository.getById(Id);

        _Attachment.setName(attachment.getName());
        _Attachment.setCreatedAt(attachment.getCreatedAt());

        return attachmentRepository.save(_Attachment);
    }

    public boolean delete(Long Id){

        try{
            attachmentRepository.deleteById(Id);

            return true;
        }catch (Exception e){
            log.error(e.getMessage());
            return false;
        }
    }
}
